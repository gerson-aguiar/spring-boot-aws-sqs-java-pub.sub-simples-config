[ ] Format this readme.md

This project demonstrates how to use LocalStack for working with AWS services locally, with
a focus on using AWS SQS (Simpl Queue Service) for creating queues and sending messages.

Prerequisites
Make sure you have the following installed and set up?
- LocalStack: To simulate AWS services locally.
- AWS CLI: For interacting with AWS services.

Getting Started

- Start LocalStack
- To start LocalStack, run the command:


`localstack start`

Creating an SQS Queue

Use the following command to create a new SQS queue:

aws --endpoint-url=http://localhost:4566 sqs create-queue \
--queue-name queue-product-update-v2 \
--region us-east-1 --profile localstack

Sending a Single Message to the Queue
Send a single message to the create queue:

aws --endpoint-url=http://localhost:4566 sqs send-message \
--queue-url http://localhost:4566/000000000000/queue-product-update-v2 \
--message-body '{"id": 123, "produto": "Notebook", "preco": 5000}' \
--profile localstack


Sending Multiple Messages to the Queue
To send multiple messages, you can use a shell script or run the
command in a loop. Here`s an example to send 50 messages to the queue. You
can adjust the count(e.g., 10,000 messages) based on your requirements:

for i in $(seq 1 50); do
aws --endpoint-url=http://localhost:4566 sqs send-message \
--queue-url http://localhost:4566/000000000000/queue-product-update-v2 \
--message-body "{\"id\": $i, \"produto\": \"Produto-$i\", \"preco\": 100}" \
--profile localstack > /dev/null &
done

Note: Sending a very high number of messages (e.g., 10,000+) could cause performance
issues, especially on lower-spec machines.

Additional Notes

- The project uses LocalStack running locally, which provides an easy way
to work with mocked AWS services without accessing the actual AWS cloud infrastructure.
- Ensure that the --endpoint-url is correclty pointing to the LocalStack instance
- --profile localstack refers to an AWS CLI profile set up specifically for
LocalStack usage.




---------



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


