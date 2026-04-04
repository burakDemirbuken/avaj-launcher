MAIN_CLASS=Main
SOURCES_FILE=sources.txt
BIN_DIR=bin
SCENARIO=scenario.txt

all: run

compile: sources
	@mkdir -p $(BIN_DIR)
	@javac -d $(BIN_DIR) @$(SOURCES_FILE)

sources:
	@find . -name "*.java" > $(SOURCES_FILE)

run: compile 
	@java -cp $(BIN_DIR) $(MAIN_CLASS) $(SCENARIO)

fclean:
	@rm -f $(SOURCES_FILE)
	@rm -rf $(BIN_DIR)

re: fclean all

.PHONY: all compile sources run fclean re