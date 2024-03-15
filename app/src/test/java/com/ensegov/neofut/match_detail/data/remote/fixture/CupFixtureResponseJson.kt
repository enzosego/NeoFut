package com.ensegov.neofut.match_detail.data.remote.fixture

internal const val cupFixtureResponseJson = """
{
  "get": "fixtures",
  "parameters": {
    "league": "2",
    "season": "2022",
    "round": "Round of 16"
  },
  "errors": [],
  "results": 16,
  "paging": {
    "current": 1,
    "total": 1
  },
  "response": [
    {
      "fixture": {
        "id": 971793,
        "referee": "Sandro Scharer, Switzerland",
        "timezone": "UTC",
        "date": "2023-02-14T20:00:00+00:00",
        "timestamp": 1676404800,
        "periods": {
          "first": 1676404800,
          "second": 1676408400
        },
        "venue": {
          "id": 907,
          "name": "Stadio Giuseppe Meazza",
          "city": "Milano"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 489,
          "name": "AC Milan",
          "logo": "https://media.api-sports.io/football/teams/489.png",
          "winner": true
        },
        "away": {
          "id": 47,
          "name": "Tottenham",
          "logo": "https://media-3.api-sports.io/football/teams/47.png",
          "winner": false
        }
      },
      "goals": {
        "home": 1,
        "away": 0
      },
      "score": {
        "halftime": {
          "home": 1,
          "away": 0
        },
        "fulltime": {
          "home": 1,
          "away": 0
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971794,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-08T20:00:00+00:00",
        "timestamp": 1678305600,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 593,
          "name": "Tottenham Hotspur Stadium",
          "city": "London"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 47,
          "name": "Tottenham",
          "logo": "https://media-3.api-sports.io/football/teams/47.png",
          "winner": null
        },
        "away": {
          "id": 489,
          "name": "AC Milan",
          "logo": "https://media.api-sports.io/football/teams/489.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971795,
        "referee": "Michael Oliver, England",
        "timezone": "UTC",
        "date": "2023-02-14T20:00:00+00:00",
        "timestamp": 1676404800,
        "periods": {
          "first": 1676404800,
          "second": 1676408400
        },
        "venue": {
          "id": 671,
          "name": "Parc des Princes",
          "city": "Paris"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 85,
          "name": "Paris Saint Germain",
          "logo": "https://media-3.api-sports.io/football/teams/85.png",
          "winner": false
        },
        "away": {
          "id": 157,
          "name": "Bayern Munich",
          "logo": "https://media-3.api-sports.io/football/teams/157.png",
          "winner": true
        }
      },
      "goals": {
        "home": 0,
        "away": 1
      },
      "score": {
        "halftime": {
          "home": 0,
          "away": 0
        },
        "fulltime": {
          "home": 0,
          "away": 1
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971796,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-08T20:00:00+00:00",
        "timestamp": 1678305600,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 700,
          "name": "Allianz Arena",
          "city": "München"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 157,
          "name": "Bayern Munich",
          "logo": "https://media.api-sports.io/football/teams/157.png",
          "winner": null
        },
        "away": {
          "id": 85,
          "name": "Paris Saint Germain",
          "logo": "https://media-3.api-sports.io/football/teams/85.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971797,
        "referee": "Davide Massa, Italy",
        "timezone": "UTC",
        "date": "2023-02-15T20:00:00+00:00",
        "timestamp": 1676491200,
        "periods": {
          "first": 1676491200,
          "second": 1676494800
        },
        "venue": {
          "id": 176,
          "name": "Jan Breydelstadion",
          "city": "Brugge"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 569,
          "name": "Club Brugge KV",
          "logo": "https://media-3.api-sports.io/football/teams/569.png",
          "winner": false
        },
        "away": {
          "id": 211,
          "name": "Benfica",
          "logo": "https://media-3.api-sports.io/football/teams/211.png",
          "winner": true
        }
      },
      "goals": {
        "home": 0,
        "away": 2
      },
      "score": {
        "halftime": {
          "home": 0,
          "away": 0
        },
        "fulltime": {
          "home": 0,
          "away": 2
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971798,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-07T20:00:00+00:00",
        "timestamp": 1678219200,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": null,
          "name": "Estádio do Sport Lisboa e Benfica",
          "city": "Lisboa"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 211,
          "name": "Benfica",
          "logo": "https://media-3.api-sports.io/football/teams/211.png",
          "winner": null
        },
        "away": {
          "id": 569,
          "name": "Club Brugge KV",
          "logo": "https://media.api-sports.io/football/teams/569.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971799,
        "referee": "Jesus Gil Manzano, Spain",
        "timezone": "UTC",
        "date": "2023-02-15T20:00:00+00:00",
        "timestamp": 1676491200,
        "periods": {
          "first": 1676491200,
          "second": 1676494800
        },
        "venue": {
          "id": 19381,
          "name": "SIGNAL IDUNA PARK",
          "city": "Dortmund"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 165,
          "name": "Borussia Dortmund",
          "logo": "https://media-3.api-sports.io/football/teams/165.png",
          "winner": true
        },
        "away": {
          "id": 49,
          "name": "Chelsea",
          "logo": "https://media-3.api-sports.io/football/teams/49.png",
          "winner": false
        }
      },
      "goals": {
        "home": 1,
        "away": 0
      },
      "score": {
        "halftime": {
          "home": 0,
          "away": 0
        },
        "fulltime": {
          "home": 1,
          "away": 0
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971800,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-07T20:00:00+00:00",
        "timestamp": 1678219200,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 519,
          "name": "Stamford Bridge",
          "city": "London"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 49,
          "name": "Chelsea",
          "logo": "https://media.api-sports.io/football/teams/49.png",
          "winner": null
        },
        "away": {
          "id": 165,
          "name": "Borussia Dortmund",
          "logo": "https://media.api-sports.io/football/teams/165.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971801,
        "referee": "I. Kovacs",
        "timezone": "UTC",
        "date": "2023-02-21T20:00:00+00:00",
        "timestamp": 1677009600,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 550,
          "name": "Anfield",
          "city": "Liverpool"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 40,
          "name": "Liverpool",
          "logo": "https://media-3.api-sports.io/football/teams/40.png",
          "winner": null
        },
        "away": {
          "id": 541,
          "name": "Real Madrid",
          "logo": "https://media-3.api-sports.io/football/teams/541.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971802,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-15T20:00:00+00:00",
        "timestamp": 1678910400,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 1456,
          "name": "Estadio Santiago Bernabéu",
          "city": "Madrid"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 541,
          "name": "Real Madrid",
          "logo": "https://media-3.api-sports.io/football/teams/541.png",
          "winner": null
        },
        "away": {
          "id": 40,
          "name": "Liverpool",
          "logo": "https://media.api-sports.io/football/teams/40.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971803,
        "referee": "Artur Soares Dias",
        "timezone": "UTC",
        "date": "2023-02-21T20:00:00+00:00",
        "timestamp": 1677009600,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 10491,
          "name": "Deutsche Bank Park",
          "city": "Frankfurt am Main"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 169,
          "name": "Eintracht Frankfurt",
          "logo": "https://media-3.api-sports.io/football/teams/169.png",
          "winner": null
        },
        "away": {
          "id": 492,
          "name": "Napoli",
          "logo": "https://media-3.api-sports.io/football/teams/492.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971804,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-15T20:00:00+00:00",
        "timestamp": 1678910400,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 11904,
          "name": "Stadio Diego Armando Maradona",
          "city": "Napoli"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 492,
          "name": "Napoli",
          "logo": "https://media.api-sports.io/football/teams/492.png",
          "winner": null
        },
        "away": {
          "id": 169,
          "name": "Eintracht Frankfurt",
          "logo": "https://media.api-sports.io/football/teams/169.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971805,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-02-22T20:00:00+00:00",
        "timestamp": 1677096000,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 738,
          "name": "Red Bull Arena",
          "city": "Leipzig"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 173,
          "name": "RB Leipzig",
          "logo": "https://media.api-sports.io/football/teams/173.png",
          "winner": null
        },
        "away": {
          "id": 50,
          "name": "Manchester City",
          "logo": "https://media-3.api-sports.io/football/teams/50.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971806,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-14T20:00:00+00:00",
        "timestamp": 1678824000,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 555,
          "name": "Etihad Stadium",
          "city": "Manchester"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 50,
          "name": "Manchester City",
          "logo": "https://media-3.api-sports.io/football/teams/50.png",
          "winner": null
        },
        "away": {
          "id": 173,
          "name": "RB Leipzig",
          "logo": "https://media-3.api-sports.io/football/teams/173.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971807,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-02-22T20:00:00+00:00",
        "timestamp": 1677096000,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 907,
          "name": "Stadio Giuseppe Meazza",
          "city": "Milano"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 505,
          "name": "Inter",
          "logo": "https://media.api-sports.io/football/teams/505.png",
          "winner": null
        },
        "away": {
          "id": 212,
          "name": "FC Porto",
          "logo": "https://media.api-sports.io/football/teams/212.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    },
    {
      "fixture": {
        "id": 971808,
        "referee": null,
        "timezone": "UTC",
        "date": "2023-03-14T20:00:00+00:00",
        "timestamp": 1678824000,
        "periods": {
          "first": null,
          "second": null
        },
        "venue": {
          "id": 1286,
          "name": "Estádio Do Dragão",
          "city": "Porto"
        },
        "status": {
          "long": "Not Started",
          "short": "NS",
          "elapsed": null
        }
      },
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "round": "Round of 16"
      },
      "teams": {
        "home": {
          "id": 212,
          "name": "FC Porto",
          "logo": "https://media.api-sports.io/football/teams/212.png",
          "winner": null
        },
        "away": {
          "id": 505,
          "name": "Inter",
          "logo": "https://media.api-sports.io/football/teams/505.png",
          "winner": null
        }
      },
      "goals": {
        "home": null,
        "away": null
      },
      "score": {
        "halftime": {
          "home": null,
          "away": null
        },
        "fulltime": {
          "home": null,
          "away": null
        },
        "extratime": {
          "home": null,
          "away": null
        },
        "penalty": {
          "home": null,
          "away": null
        }
      }
    }
  ]
}
"""