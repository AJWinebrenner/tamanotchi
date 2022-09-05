api-build:
	@docker build -t tamanotchi-back ./tamanotchi_spring 
.PHONY: api-build

ui-build:
	@docker build -t tamanotchi-front ./tamanotchi_react 
.PHONY: ui-build

db-build:
	@docker build -t tamanotchi-db ./database
.PHONY: db-build

build: db-build api-build ui-build

run:
	@docker-compose -f ./docker/docker-compose.yml up
.PHONY: run