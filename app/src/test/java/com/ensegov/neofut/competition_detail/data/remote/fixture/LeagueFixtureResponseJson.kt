package com.ensegov.neofut.competition_detail.data.remote.fixture

internal const val leagueFixtureResponseJson = """
{
  "get": "fixtures",
  "parameters": {
    "league": "39",
    "season": "2022",
    "round": "Regular Season - 1"
  },
  "errors": [],
  "results": 10,
  "paging": {
    "current": 1,
    "total": 1
  },
  "response": [
    {
      "fixture": {
        "id": 867946,
        "referee": "Anthony Taylor, England",
        "timezone": "UTC",
        "date": "2022-08-05T19:00:00+00:00",
        "timestamp": 1659726000,
        "periods": {
          "first": 1659726000,
          "second": 1659729600
        },
        "venue": {
          "id": 525,
          "name": "Selhurst Park",
          "city": "London"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 52,
          "name": "Crystal Palace",
          "logo": "https://media-3.api-sports.io/football/teams/52.png",
          "winner": false
        },
        "away": {
          "id": 42,
          "name": "Arsenal",
          "logo": "https://media-3.api-sports.io/football/teams/42.png",
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
          "away": 1
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
        "id": 867947,
        "referee": "Andy Madley, England",
        "timezone": "UTC",
        "date": "2022-08-06T11:30:00+00:00",
        "timestamp": 1659785400,
        "periods": {
          "first": 1659785400,
          "second": 1659789000
        },
        "venue": {
          "id": 535,
          "name": "Craven Cottage",
          "city": "London"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 36,
          "name": "Fulham",
          "logo": "https://media.api-sports.io/football/teams/36.png",
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
        "home": 2,
        "away": 2
      },
      "score": {
        "halftime": {
          "home": 1,
          "away": 0
        },
        "fulltime": {
          "home": 2,
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
        "id": 867948,
        "referee": "Peter Bankes, England",
        "timezone": "UTC",
        "date": "2022-08-06T14:00:00+00:00",
        "timestamp": 1659794400,
        "periods": {
          "first": 1659794400,
          "second": 1659798000
        },
        "venue": {
          "id": 504,
          "name": "Vitality Stadium",
          "city": "Bournemouth, Dorset"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 35,
          "name": "Bournemouth",
          "logo": "https://media.api-sports.io/football/teams/35.png",
          "winner": true
        },
        "away": {
          "id": 66,
          "name": "Aston Villa",
          "logo": "https://media.api-sports.io/football/teams/66.png",
          "winner": false
        }
      },
      "goals": {
        "home": 2,
        "away": 0
      },
      "score": {
        "halftime": {
          "home": 1,
          "away": 0
        },
        "fulltime": {
          "home": 2,
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
        "id": 867949,
        "referee": "Robert Jones, England",
        "timezone": "UTC",
        "date": "2022-08-06T14:00:00+00:00",
        "timestamp": 1659794400,
        "periods": {
          "first": 1659794400,
          "second": 1659798000
        },
        "venue": {
          "id": 546,
          "name": "Elland Road",
          "city": "Leeds, West Yorkshire"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 63,
          "name": "Leeds",
          "logo": "https://media-3.api-sports.io/football/teams/63.png",
          "winner": true
        },
        "away": {
          "id": 39,
          "name": "Wolves",
          "logo": "https://media.api-sports.io/football/teams/39.png",
          "winner": false
        }
      },
      "goals": {
        "home": 2,
        "away": 1
      },
      "score": {
        "halftime": {
          "home": 1,
          "away": 1
        },
        "fulltime": {
          "home": 2,
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
        "id": 867950,
        "referee": "Jarred Gillett, Australia",
        "timezone": "UTC",
        "date": "2022-08-07T13:00:00+00:00",
        "timestamp": 1659877200,
        "periods": {
          "first": 1659877200,
          "second": 1659880800
        },
        "venue": {
          "id": 547,
          "name": "King Power Stadium",
          "city": "Leicester, Leicestershire"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 46,
          "name": "Leicester",
          "logo": "https://media-3.api-sports.io/football/teams/46.png",
          "winner": null
        },
        "away": {
          "id": 55,
          "name": "Brentford",
          "logo": "https://media.api-sports.io/football/teams/55.png",
          "winner": null
        }
      },
      "goals": {
        "home": 2,
        "away": 2
      },
      "score": {
        "halftime": {
          "home": 1,
          "away": 0
        },
        "fulltime": {
          "home": 2,
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
        "id": 867951,
        "referee": "Simon Hooper, England",
        "timezone": "UTC",
        "date": "2022-08-06T14:00:00+00:00",
        "timestamp": 1659794400,
        "periods": {
          "first": 1659794400,
          "second": 1659798000
        },
        "venue": {
          "id": 562,
          "name": "St. James' Park",
          "city": "Newcastle upon Tyne"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 34,
          "name": "Newcastle",
          "logo": "https://media.api-sports.io/football/teams/34.png",
          "winner": true
        },
        "away": {
          "id": 65,
          "name": "Nottingham Forest",
          "logo": "https://media-3.api-sports.io/football/teams/65.png",
          "winner": false
        }
      },
      "goals": {
        "home": 2,
        "away": 0
      },
      "score": {
        "halftime": {
          "home": 0,
          "away": 0
        },
        "fulltime": {
          "home": 2,
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
        "id": 867952,
        "referee": "Andre Marriner, England",
        "timezone": "UTC",
        "date": "2022-08-06T14:00:00+00:00",
        "timestamp": 1659794400,
        "periods": {
          "first": 1659794400,
          "second": 1659798000
        },
        "venue": {
          "id": 593,
          "name": "Tottenham Hotspur Stadium",
          "city": "London"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 47,
          "name": "Tottenham",
          "logo": "https://media-3.api-sports.io/football/teams/47.png",
          "winner": true
        },
        "away": {
          "id": 41,
          "name": "Southampton",
          "logo": "https://media.api-sports.io/football/teams/41.png",
          "winner": false
        }
      },
      "goals": {
        "home": 4,
        "away": 1
      },
      "score": {
        "halftime": {
          "home": 2,
          "away": 1
        },
        "fulltime": {
          "home": 4,
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
        "id": 867953,
        "referee": "Craig Pawson, England",
        "timezone": "UTC",
        "date": "2022-08-06T16:30:00+00:00",
        "timestamp": 1659803400,
        "periods": {
          "first": 1659803400,
          "second": 1659807000
        },
        "venue": {
          "id": 8560,
          "name": "Goodison Park",
          "city": "Liverpool"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 45,
          "name": "Everton",
          "logo": "https://media-3.api-sports.io/football/teams/45.png",
          "winner": false
        },
        "away": {
          "id": 49,
          "name": "Chelsea",
          "logo": "https://media.api-sports.io/football/teams/49.png",
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
          "away": 1
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
        "id": 867954,
        "referee": "Paul Tierney, England",
        "timezone": "UTC",
        "date": "2022-08-07T13:00:00+00:00",
        "timestamp": 1659877200,
        "periods": {
          "first": 1659877200,
          "second": 1659880800
        },
        "venue": {
          "id": 556,
          "name": "Old Trafford",
          "city": "Manchester"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 33,
          "name": "Manchester United",
          "logo": "https://media.api-sports.io/football/teams/33.png",
          "winner": false
        },
        "away": {
          "id": 51,
          "name": "Brighton",
          "logo": "https://media.api-sports.io/football/teams/51.png",
          "winner": true
        }
      },
      "goals": {
        "home": 1,
        "away": 2
      },
      "score": {
        "halftime": {
          "home": 0,
          "away": 2
        },
        "fulltime": {
          "home": 1,
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
        "id": 867955,
        "referee": "Michael Oliver, England",
        "timezone": "UTC",
        "date": "2022-08-07T15:30:00+00:00",
        "timestamp": 1659886200,
        "periods": {
          "first": 1659886200,
          "second": 1659889800
        },
        "venue": {
          "id": 598,
          "name": "London Stadium",
          "city": "London"
        },
        "status": {
          "long": "Match Finished",
          "short": "FT",
          "elapsed": 90
        }
      },
      "league": {
        "id": 39,
        "name": "Premier League",
        "country": "England",
        "logo": "https://media-3.api-sports.io/football/leagues/39.png",
        "flag": "https://media-3.api-sports.io/flags/gb.svg",
        "season": 2022,
        "round": "Regular Season - 1"
      },
      "teams": {
        "home": {
          "id": 48,
          "name": "West Ham",
          "logo": "https://media-3.api-sports.io/football/teams/48.png",
          "winner": false
        },
        "away": {
          "id": 50,
          "name": "Manchester City",
          "logo": "https://media.api-sports.io/football/teams/50.png",
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
          "away": 1
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
    }
  ]
} 
"""