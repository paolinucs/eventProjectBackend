# eventProjectBackend
Progetto di Programmazione III e Laboratorio di Programmazione III presso l'Università degli Studi di Napoli "Parthenope".
Il seguente progetto ha anche lo scopo di backend per il progetto d'esame di Tecnologie Web, Reti Di Calcolatori e Ingegneria del Software.

Gli sviluppatori che si sono dedicati allo sviluppo del software sono presenti all'interno della sezione "Contributors" di questa repository.

#### Tecnologie utilizzate:
- Spring Boot
- SQLite3
- Brevo

##### :information_source: Questa versione del software contiene molte falle a livello di sicurezza e performance. Il suo attuale scopo è quello di essere un supporto per il sostenimento dell'esame di Tecnologie Web. Successivamente, per l'esame di Programmazione III e reti saranno implementate funzionalità e design pattern ad-hoc.


## API

### Eventi

#### Creazione di un nuovo evento

- API URL: :link:```/api/events/new```
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

- API URL: :link:```/api/events/get_all```
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

- API URL: :link:```/api/events/by_category/{your_category}```
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

- API URL: :link:```/api/events/by_id/{your_id}```
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
#### Eliminare un evento esistente

N.B. per chiamare questo API bisogna prima avere il JSON completo della tupla che si desidera eliminare.

Bisognerà quindi passare in input tutto il JSON, se non lo si possiede bisogna prima ottenere tutti i dati relativi a un singolo evento per ID.

- API URL: :link:```/api/events/delete```
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


### Richieste eventi


#### Registrare una nuova richiesta evento

- API URL: :link:```/api/event_requests/get_all```
- Request Method: ```POST```
- JSON input example:
    ```json
    {
     "promoterId": 2,
     "permissionDocumentPath": "permesso.png",
     "promoterIdCardPath": "carta_identita.png",
     "locationAddress": "Via La Boutique 10,1234,Springfield",
     "maxCustomers": 90,
     "locationName": "La luna di perla",
     "locationDescription": "Un luogo incantevole al chiaro di luna"
    }
    ```


#### Eliminare una richiesta esistente
N.B. per chiamare questo API bisogna prima avere il JSON completo della tupla che si desidera eliminare.

Bisognerà quindi passare in input tutto il JSON, se non lo si possiede bisogna prima ottenere tutti i dati relativi a un singolo evento (ex. per ID).

- API URL: :link:```/api/event_requests/delete```
- Request Method: ```POST```
- JSON input example:
    ```json
    {
     "eventRequestId": 1,
     "promoterId": 2,
     "permissionDocumentPath": "permesso.png",
     "promoterIdCardPath": "carta_identita.png",
     "locationAddress": "Via La Boutique 10,1234,Springfield",
     "maxCustomers": 90,
     "locationName": "La luna di perla",
     "locationDescription": "Un luogo incantevole al chiaro di luna"
    }
    ```
#### Ottenere i dettagli di una singola Richiesta, filtrando per ID

- API URL: :link:```/api/event_requests/by_id/{your_id}```
- Request Method: ```GET```
- JSON output example:
    ```json
    {
     "eventRequestId": 1,
     "promoterId": 2,
     "permissionDocumentPath": "permesso.png",
     "promoterIdCardPath": "carta_identita.png",
     "locationAddress": "Via La Boutique 10,1234,Springfield",
     "maxCustomers": 90,
     "locationName": "La luna di perla",
     "locationDescription": "Un luogo incantevole al chiaro di luna"
    }
    ```
#### Ottenere i dettagli di tutti gli eventi

- API URL: :link:```/api/event_requests/get_all```
- Request Method: ```GET```
- JSON output example:
    ```json
    [
    {
     "eventRequestId": 1,
     "promoterId": 2,
     "permissionDocumentPath": "permesso.png",
     "promoterIdCardPath": "carta_identita.png",
     "locationAddress": "Via La Boutique 10,1234,Springfield",
     "maxCustomers": 90,
     "locationName": "La luna di perla",
     "locationDescription": "Un luogo incantevole al chiaro di luna"
    }
    {
     "eventRequestId": 2,
     "promoterId": 4,
     "permissionDocumentPath": "permesso.png",
     "promoterIdCardPath": "carta_identita.png",
     "locationAddress": "Via Intossiche,4321,Zuzzulo",
     "maxCustomers": 68,
     "locationName": "Il mezzogiorno di fuoco",
     "locationDescription": "Il freddo qui non è ben accetto"
    }
    ]
    ```

### Ticket di supporto

E' possibile inviare ticket di supporto tramite mail con chiamata API

- API URL: :link:```/api/email/send_support_ticket```
- Request Method: ```POST```
- JSON input example:

    ```json
    {
    "userRealName": "Mario",
    "userRealSurname": "Rossi",
    "userEmail": "rossimario@example.xyz",
    "ticketDescription": "Come mai non riesco a comprare nessun biglietto? C'è scritto pagamento rifiutato per saldo insufficiente!!!"
    }
    ```
