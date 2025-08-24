SCHEMA_PATH=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
GEN_DIR=gen

deps.lock:
	go mod tidy
	go run deps/run.go

gen.reset:
	find $(SCHEMA_PATH)/$(GEN_DIR) -type f -exec git update-index --assume-unchanged '{}' \;

gen.go.clean:
	find $(SCHEMA_PATH)/$(GEN_DIR)/go -type f \( -iname \*.pb.go -o -iname \*.pb.gw.go -o -iname \*.swagger.json \) -exec rm -rf {} \;

gen.java.clean:
	rm -rf $(SCHEMA_PATH)/$(GEN_DIR)/java & rm -rf $(SCHEMA_PATH)/protokotlin/build

buf.lint:
	buf lint

buf.gen:
	buf generate

buf.build: gen.go.clean gen.java.clean buf.lint buf.gen

lint: buf.lint

build: buf.build