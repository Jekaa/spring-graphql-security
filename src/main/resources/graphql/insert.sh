curl -v -u admin:password http://localhost:8080/graphql \
-H 'Content-Type: application/json' \
--data-raw '{"query":"mutation { insert(name: \"Eugene\") {id, name})}"}'