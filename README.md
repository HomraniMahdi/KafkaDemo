# Kafka Demo

Projet simple démontrant l'intégration de Spring Boot avec Apache Kafka pour la publication et la consommation de commandes.

## Technologies

- Java 21
- Spring Boot
- Spring Kafka
- Apache Kafka
- Lombok
- Maven

## Fonctionnement

1. Une commande est envoyée via une API REST.
2. Le Producer publie le message dans le topic `orders-topic`.
3. Un identifiant unique est généré automatiquement.
4. Le Consumer récupère le message et l'affiche dans les logs.

## Endpoint

### Créer une commande

```http
POST /api/orders
