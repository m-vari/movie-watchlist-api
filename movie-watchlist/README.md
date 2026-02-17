# 🎬 Movie Watchlist API

REST API per gestire la tua watchlist personale di film, sviluppata con Spring Boot.

## Tecnologie
- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Maven

## Architettura
Il progetto segue un'architettura a layer:
- **Controller** → gestisce le richieste HTTP
- **Service** → contiene la business logic (interfaccia + implementazione)
- **Repository** → accesso ai dati con Spring Data JPA
- **DTO + Mapper** → separazione tra modello DB e modello API
- **Exception Handler** → gestione centralizzata degli errori

## Come avviarlo
1. Clona il repository
```bash
git clone https://github.com/m-vari/movie-watchlist-api
cd movie-watchlist-api/movie-watchlist
```

2. Avvia l'applicazione
```bash
mvn spring-boot:run
```

3. L'API è disponibile su `http://localhost:8080`

## Endpoints

### Movies
| Method | Endpoint | Descrizione |
|--------|----------|-------------|
| GET | /api/movies | Lista tutti i film |
| GET | /api/movies/{id} | Film per ID |
| GET | /api/movies/status/{status} | Film per status |
| GET | /api/movies/genre/{genre} | Film per genere |
| GET | /api/movies/search?title={title} | Cerca per titolo |
| GET | /api/movies/rating?minRating={n} | Film per rating minimo |
| POST | /api/movies | Crea nuovo film |
| PUT | /api/movies/{id} | Aggiorna film |
| DELETE | /api/movies/{id} | Elimina film |

## Status disponibili
- `TO_WATCH` - Da vedere
- `WATCHING` - In corso
- `WATCHED` - Visto

## Esempio di richiesta POST
```json
{
  "title": "Inception",
  "genre": "Sci-Fi",
  "year": 2010,
  "rating": 9,
  "notes": "Capolavoro di Nolan",
  "status": "WATCHED"
}
```

## Status Codes
- `200 OK` - Successo
- `201 Created` - Film creato
- `204 No Content` - Film eliminato
- `400 Bad Request` - Dati non validi
- `404 Not Found` - Film non trovato
- `500 Internal Server Error` - Errore server
