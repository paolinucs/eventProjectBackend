# eventProjectBackend
Progetto di Programmazione III e Laboratorio di Programmazione III presso l'Università degli Studi di Napoli "Parthenope".
Il seguente progetto ha anche lo scopo di backend per il progetto d'esame di Tecnologie Web, Reti Di Calcolatori e Ingegneria del Software.

Gli sviluppatori che si sono dedicati allo sviluppo del software sono presenti all'interno della sezione "Contributors" di questa repository.

#### Tecnologie utilizzate:
- Spring Boot
- SQLite3

##### N.B questa versione del software contiene molte falle a livello di sicurezza e performance. Il suo attuale scopo è quello di essere un supporto per il sostenimento dell'esame di Tecnologie Web. Successivamente, per l'esame di Programmazione III e reti saranno implementate funzionalità e design pattern ad-hoc.


## API

### Eventi

#### Creazione di un nuovo evento

- API URL: ```/api/events/by_category/new```
- Request Method: ```POST```
- JSON input example:
    ```json
    {
    "eventName": "La Perla Nera",
    "eventDescription": "Tutte le meraviglie de I Pirati dei Caraibi in un solo luogo",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cinema",
    "eventRegion": "Piemonte"
    }
    ```

#### Ottenere i dettagli di tutti gli eventi

- API URL: ```/api/events/by_category/get_all```
- Request Method: ```GET```
- JSON output example:
    ```json
    [{
    "eventId": 1,
    "eventName": "La Perla Nera",
    "eventDescription": "Tutte le meraviglie de I Pirati dei Caraibi in un solo luogo",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cinema",
    "eventRegion": "Piemonte"
    }
    {
    "eventId": 7,
    "eventName": "La Fiera Delle Merende",
    "eventDescription": "Per tutti gli appassionati delle classiche \"merende\" napoletane",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cucina",
    "eventRegion": "Campania"
    }
    ]
    ```
#### Ottenere i dettagli di più eventi, filtrandoli per categoria

- API URL: ```/api/events/by_category/by_category/{your_category}```
- Request Method: ```GET```
- JSON output example:
    ```json
    [{
    "eventId": 4,
    "eventName": "Sarà davvero una torta?",
    "eventDescription": "Se sei un appassionato di dolci e ami le sorprese, facciamo al caso tuo!",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cucina",
    "eventRegion": "Lazio"
    }
    {
    "eventId": 7,
    "eventName": "La Fiera Delle Merende",
    "eventDescription": "Per tutti gli appassionati delle classiche merende napoletane",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cucina",
    "eventRegion": "Campania"
    }
    ]
    ```
#### Ottenere i dettagli di un singolo evento, filtrando per ID

- API URL: ```/api/events/by_category/by_id/{your_id}```
- Request Method: ```GET```
- JSON output example:
    ```json
    {
    "eventId": 4,
    "eventName": "Sarà davvero una torta?",
    "eventDescription": "Se sei un appassionato di dolci e ami le sorprese, facciamo al caso tuo!",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cucina",
    "eventRegion": "Lazio"
    }
    ```
#### Eliminare un evento esistente per ID

N.b per chiamare questo API bisogna prima avere il JSON completo della tupla che si desidera eliminare.

Bisognerà quindi passare in input tutto il JSON, se non lo si possiede bisogna prima ottenere tutti i dati relativi a un singolo evento per ID.

- API URL: ```/api/events/by_category/by_id/```
- Request Method: ```POST```
- JSON input example:
    ```json
    {
    "eventId": 4,
    "eventName": "Sarà davvero una torta?",
    "eventDescription": "Se sei un appassionato di dolci e ami le sorprese, facciamo al caso tuo!",
    "maximumCapacity": 70,
    "eventDate": "2024-05-20",
    "eventCategory": "Cucina",
    "eventRegion": "Lazio"
    }
    ```







da fare:

- nuova richiesta evento
- elimina richiesta evento
- eventi per categoriaok
- utenti e clienti, registrazione e autenticazione
