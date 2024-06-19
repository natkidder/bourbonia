curl --location --request POST 'https://data.mongodb-api.com/app/data-kwsig/endpoint/data/v1/action/findOne' \
--header 'Content-Type: application/json' \
--header 'Access-Control-Request-Headers: *' \
--header 'api-key: Cluster0_API_Key' \
--data-raw '{
    "dataSource":"Cluster0",
    "database":"sample_mflix",
    "collection":"movies",
    "projection": {"title": 1}
}'
