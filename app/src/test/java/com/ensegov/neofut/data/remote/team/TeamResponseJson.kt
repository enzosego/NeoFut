package com.ensegov.neofut.data.remote.team

internal const val teamResponseJson = """
{
  "get": "teams",
  "parameters": {
    "id": "435"
  },
  "errors": [],
  "results": 1,
  "paging": {
    "current": 1,
    "total": 1
  },
  "response": [
    {
      "team": {
        "id": 435,
        "name": "River Plate",
        "code": "RIV",
        "country": "Argentina",
        "founded": 1901,
        "national": false,
        "logo": "https://media.api-sports.io/football/teams/435.png"
      },
      "venue": {
        "id": 31,
        "name": "Estadio Monumental Antonio Vespucio Liberti",
        "address": "Avenida Presidente José Figueroa Alcorta 7597, Núñez",
        "city": "Capital Federal, Ciudad de Buenos Aires",
        "capacity": 65645,
        "surface": "grass",
        "image": "https://media.api-sports.io/football/venues/31.png"
      }
    }
  ]
}
"""