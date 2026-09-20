# Kafka Demo

Application de démonstration basée sur Spring Boot, Apache Kafka et Angular permettant l'envoi et la consommation de commandes en temps réel.

## Technologies

### Backend
- Java 21
- Spring Boot
- Spring Kafka
- Apache Kafka
- Lombok
- Maven

### Frontend
- Angular
- Reactive Forms
- HttpClient
- Bootstrap

## Fonctionnalités

- Création d'une commande via une API REST.
- Formulaire Angular avec validation grâce aux Reactive Forms.
- Génération automatique d'un identifiant unique (UUID).
- Publication des commandes dans Kafka.
- Consommation des messages depuis un topic Kafka.
- Affichage des commandes reçues dans les logs.

## Architecture

```text
Angular UI
    │
    ▼
Spring Boot REST API
    │
    ▼
Kafka Producer
    │
    ▼
orders-topic
    │
    ▼
Kafka Consumer
```

## Endpoint API

### Créer une commande

```http
POST /api/orders
```

### Exemple de requête

```json
{
  "customerName": "Mahdi",
  "product": "Laptop",
  "quantity": 2
}
```

## Exemple de message Kafka

```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "customerName": "Mahdi",
  "product": "Laptop",
  "quantity": 2
}
```

L'identifiant est généré automatiquement sous forme d'UUID et utilisé comme clé du message Kafka.

## Lancement

### Démarrer Kafka

```bash
docker-compose up -d
```

### Démarrer le backend

```bash
mvn spring-boot:run
```

### Démarrer le frontend

```bash
npm install
ng serve
```

## Topic Kafka

```text
orders-topic
```

## Exemple de log

```text
Commande reçue

Id        : 550e8400-e29b-41d4-a716-446655440000
Client    : Mahdi
Produit   : Laptop
Quantité  : 2
```
