# Configuration
# Override port with: make PORT=4200
PORT ?= 4100
REPO_NAME ?= arnav_2025
LOG_FILE = /tmp/jekyll$(PORT).log

# Shell configuration
SHELL = /bin/bash
.SHELLFLAGS = -e

# Phony Targets
.PHONY: default server issues convert clean stop help

# Help target
help:
	@echo "Available targets:"
	@echo "  make          - Start the development server (default)"
	@echo "  make server   - Start the development server"
	@echo "  make convert  - Convert Jupyter notebooks to Markdown"
	@echo "  make clean    - Clean up generated files"
	@echo "  make stop     - Stop the development server"
	@echo "  make help     - Show this help message"
	@echo ""
	@echo "Configuration:"
	@echo "  PORT=4200 make  - Start server on port 4200"

# List all .ipynb files in the _notebooks directory, handling spaces in filenames
NOTEBOOK_FILES := $(shell find _notebooks -name '*.ipynb' | sed 's/ /\\ /g')

# Specify the target directory for the converted Markdown files
DESTINATION_DIRECTORY = _posts
MARKDOWN_FILES := $(patsubst _notebooks/%.ipynb,$(DESTINATION_DIRECTORY)/%_IPYNB_2_.md,$(NOTEBOOK_FILES))

# Default target to start the server
default: server
	@echo "Terminal logging starting, watching server..."
	@(tail -f $(LOG_FILE) | awk '/Server address: http:\/\/127.0.0.1:$(PORT)\/$(REPO_NAME)\// { serverReady=1 } \
	serverReady && /^ *Regenerating:/ { regenerate=1 } \
	regenerate { \
		if (/^[[:blank:]]*$$/) { regenerate=0 } \
		else { \
			print; \
			if ($$0 ~ /_notebooks\/.*\.ipynb/) { system("make convert &") } \
		} \
	}') 2>/dev/null &
	@for ((COUNTER = 0; ; COUNTER++)); do \
		if grep -q "Server address:" $(LOG_FILE); then \
			echo "Server started in $$COUNTER seconds"; \
			break; \
		fi; \
		if [ $$COUNTER -eq 60 ]; then \
			echo "Error: Server timed out after $$COUNTER seconds."; \
			echo "Please check the following:"; \
			echo "1. Is port $(PORT) available?"; \
			echo "2. Are all dependencies installed? (run 'bundle install')"; \
			echo "3. Review errors from $(LOG_FILE):"; \
			cat $(LOG_FILE); \
			exit 1; \
		fi; \
		sleep 1; \
	done
	@sed '$$d' $(LOG_FILE)

# Start the local web server
server: stop convert
	@echo "Starting server..."
	@if ! command -v bundle &> /dev/null; then \
		echo "Error: 'bundle' command not found. Please install Ruby and Bundler."; \
		exit 1; \
	fi
	@nohup bundle exec jekyll serve -H 127.0.0.1 -P $(PORT) > $(LOG_FILE) 2>&1 & \
		PID=$$!; \
		echo "Server PID: $$PID"
	@until [ -f $(LOG_FILE) ]; do sleep 1; done

# Convert .ipynb files to Markdown with front matter
convert: $(MARKDOWN_FILES)

# Convert .ipynb files to Markdown with front matter, handling spaces in filenames
$(DESTINATION_DIRECTORY)/%_IPYNB_2_.md: _notebooks/%.ipynb
	@echo "Converting source $< to destination $@"
	@mkdir -p $(@D)
	@python -c 'import sys; from scripts.convert_notebooks import convert_single_notebook; convert_single_notebook(sys.argv[1])' "$<"

# Clean up project derived files
clean: stop
	@echo "Cleaning converted IPYNB files..."
	@find _posts -type f -name '*_IPYNB_2_.md' -exec rm {} +
	@echo "Cleaning Github Issue files..."
	@find _posts -type f -name '*_GithubIssue_.md' -exec rm {} +
	@echo "Removing empty directories in _posts..."
	@while [ $$(find _posts -type d -empty | wc -l) -gt 0 ]; do \
		find _posts -type d -empty -exec rmdir {} +; \
	done
	@echo "Removing _site directory..."
	@rm -rf _site
	@echo "Clean complete. Run 'make' to start fresh."

# Stop the server and kill processes
stop:
	@echo "Stopping server..."
	@lsof -ti :$(PORT) | xargs kill >/dev/null 2>&1 || true
	@echo "Stopping logging process..."
	@ps aux | awk -v log_file=$(LOG_FILE) '$$0 ~ "tail -f " log_file { print $$2 }' | xargs kill >/dev/null 2>&1 || true
	@rm -f $(LOG_FILE)
	@echo "Server stopped."
