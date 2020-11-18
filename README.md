# School schema for subjects, students and teachers.

GET all subjects
GET Single student with they subjects
GET all students by teacher
GET all students by subject and teacher
GET all student by subject

POST Subject (containing subject (as string) and student id)
POST Student (containing student (field Strings) and subject id)
POST Teacher (containing teacher (as string) and subject id)

PUT Subject
PUT Student
PUT Teacher




## POST player

Post a player with json formated data. 
All fields must be filled except phone number. If a field is missing, you get 400 bad request as answer.

```html
localhost:8080/PlayerDataEEDemo/api/v1/item/postPlayer
```
Example data to send:
```json
{
  "firstName": "Anakin",
  "lastname": "Skywalker",
  "email": "Anakin.skywalker@waltilla.com",
  "phoneNumber": "0707121314"
}
```


## GET all players

Get all player will return a json formated list of players.

```html
localhost:8080/PlayerDataEEDemo/api/v1/item/getAllPlayers
```
Exampledata received:
```json
[
  {
    "email": "Anakin.skywalker@waltilla.com",
    "firstName": "Anakin",
    "id": 1,
    "lastname": "Skywalker",
    "phoneNumber": "0707121314"
  },
  {
    "email": "Luke.skywalker@waltilla.com",
    "firstName": "Luke",
    "id": 2,
    "lastname": "Skywalker",
    "phoneNumber": "0707151617"
  }
]
```


## GET specific player by last name

Get all player will return a json formated list of players with the same last name.

```html
localhost:8080/PlayerDataEEDemo/api/v1/item/getByLastName/Skywalker
```
Exampledata received:

```json

{
   "email": "Luke.skywalker@waltilla.com",
   "firstName": "Luke",
   "id": 1,
   "lastname": "Skywalker",
   "phoneNumber": "0707151617"
}

```

## PUT update player

Uppdate a player by send player data as json with all fields and same data is returnd as validation.

```html
localhost:8080/PlayerDataEEDemo/api/v1/item/updatePlayer
```
Exampledata sent and received:

```json

{
  "email": "Lea.skywalker@waltilla.com",
  "firstName": "Lea",
  "id": 1,
  "lastname": "Skywalker",
  "phoneNumber": "0704085005"
}

```

## DELETE player

Delete a player by send its id, if success you get a message with confirmation.

```html
localhost:8080/PlayerDataEEDemo/api/v1/item/deletePlayer/1
```
Exampledata received:

```json
Player with ID 1 deleted.
```

## Contributing

[MOON - Hydrogen](https://www.youtube.com/watch?v=SNE2oCZH_4k)
