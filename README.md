Start localStack

`localstack start`

Criando filas:
aws --endpoint-url=http://localhost:4566 sqs create-queue \
    --queue-name queue-product-update-v2 \
    --region us-east-1 --profile localstack

Enviando message:
aws --endpoint-url=http://localhost:4566 sqs send-message \
    --queue-url http://localhost:4566/000000000000/queue-product-update-v2 \
    --message-body '{"id": 123, "produto": "Notebook", "preco": 5000}' \
    --profile localstack


Enviando 50 message. Pode alterar de 50 para 10.000 por exemplo.
Porem apenas da forma que esta, com 10K estava travando meu MacBook
entao deixei apenas 50.
for i in $(seq 1 50); do
    aws --endpoint-url=http://localhost:4566 sqs send-message \
        --queue-url http://localhost:4566/000000000000/queue-product-update-v2 \
        --message-body "{\"id\": $i, \"produto\": \"Produto-$i\", \"preco\": 100}" \
        --profile localstack > /dev/null &
done