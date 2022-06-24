curl -v -u gordienkoee:password http://localhost:8080/graphql \
-H 'Content-Type: application/json' \
--data-raw '{"query":"{ customerById(is:1) {id, name})}"}'