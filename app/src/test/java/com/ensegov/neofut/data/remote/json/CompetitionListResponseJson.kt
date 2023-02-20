package com.ensegov.neofut.data.remote.json

const val competitionListResponseJson = """
{
  "get": "leagues",
  "parameters": {
    "country": "argentina"
  },
  "errors": [],
  "results": 11,
  "paging": {
    "current": 1,
    "total": 1
  },
  "response": [
    {
      "league": {
        "id": 134,
        "name": "Torneo Federal A",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/134.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2011,
          "start": "2011-08-20",
          "end": "2012-06-24",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2012,
          "start": "2012-08-19",
          "end": "2013-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2013,
          "start": "2013-08-17",
          "end": "2014-06-08",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2014,
          "start": "2014-08-23",
          "end": "2014-12-07",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2015,
          "start": "2015-03-21",
          "end": "2015-12-10",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-09-03",
          "end": "2017-07-16",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-09-16",
          "end": "2018-05-27",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-09-08",
          "end": "2019-06-23",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-08-31",
          "end": "2020-05-02",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-12-04",
          "end": "2021-01-31",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-04-10",
          "end": "2021-12-05",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-03-26",
          "end": "2022-11-13",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 129,
        "name": "Primera Nacional",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/129.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2011,
          "start": "2011-08-06",
          "end": "2012-06-23",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2012,
          "start": "2012-08-11",
          "end": "2013-06-17",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2013,
          "start": "2013-08-03",
          "end": "2014-06-11",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2014,
          "start": "2014-08-09",
          "end": "2014-12-19",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2015,
          "start": "2015-02-13",
          "end": "2015-12-06",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-08-27",
          "end": "2017-07-30",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-09-16",
          "end": "2018-06-03",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-08-25",
          "end": "2019-06-08",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-08-16",
          "end": "2020-05-16",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-11-28",
          "end": "2021-02-01",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-03-12",
          "end": "2021-12-21",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-02-11",
          "end": "2022-11-19",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-02-04",
          "end": "2023-06-09",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": true
          }
        }
      ]
    },
    {
      "league": {
        "id": 131,
        "name": "Primera B Metropolitana",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/131.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2011,
          "start": "2011-08-06",
          "end": "2012-05-25",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2012,
          "start": "2012-08-04",
          "end": "2013-06-22",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2013,
          "start": "2013-08-02",
          "end": "2014-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2014,
          "start": "2014-08-08",
          "end": "2014-12-08",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2015,
          "start": "2015-02-14",
          "end": "2015-12-07",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-08-26",
          "end": "2017-08-03",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-09-02",
          "end": "2018-05-26",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-08-17",
          "end": "2019-06-20",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-08-03",
          "end": "2021-01-03",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-12-04",
          "end": "2021-02-05",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-03-06",
          "end": "2021-12-19",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-02-12",
          "end": "2022-11-05",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-02-11",
          "end": "2023-06-03",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": true
          }
        }
      ]
    },
    {
      "league": {
        "id": 132,
        "name": "Primera C",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/132.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2011,
          "start": "2011-08-06",
          "end": "2012-06-22",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2012,
          "start": "2012-08-04",
          "end": "2013-06-29",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2013,
          "start": "2013-08-02",
          "end": "2014-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2014,
          "start": "2014-08-08",
          "end": "2014-12-08",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2015,
          "start": "2015-02-13",
          "end": "2015-12-08",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-08-26",
          "end": "2017-07-29",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-09-02",
          "end": "2018-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-08-18",
          "end": "2019-06-30",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-07-27",
          "end": "2021-01-16",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-12-05",
          "end": "2021-01-31",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-03-06",
          "end": "2021-12-18",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-02-12",
          "end": "2022-11-19",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-01-27",
          "end": "2023-06-02",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": true
          }
        }
      ]
    },
    {
      "league": {
        "id": 133,
        "name": "Primera D",
        "type": "League",
        "logo": "https://media-3.api-sports.io/football/leagues/133.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2011,
          "start": "2011-08-20",
          "end": "2012-06-22",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2012,
          "start": "2012-08-12",
          "end": "2013-06-21",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2013,
          "start": "2013-08-02",
          "end": "2014-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2014,
          "start": "2014-08-09",
          "end": "2014-12-13",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2015,
          "start": "2015-03-13",
          "end": "2015-11-30",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-08-28",
          "end": "2017-07-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-09-02",
          "end": "2018-06-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-09-01",
          "end": "2019-06-20",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-09-06",
          "end": "2020-05-02",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-12-04",
          "end": "2021-01-30",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-05-09",
          "end": "2021-12-18",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-05-07",
          "end": "2022-10-16",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-03-18",
          "end": "2023-11-25",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 128,
        "name": "Liga Profesional Argentina",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/128.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2015,
          "start": "2015-02-13",
          "end": "2015-12-07",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": false
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2016,
          "start": "2016-08-26",
          "end": "2017-06-27",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-08-25",
          "end": "2018-05-15",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-08-10",
          "end": "2019-04-07",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-07-27",
          "end": "2020-03-10",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": true,
            "top_scorers": true,
            "top_assists": true,
            "top_cards": true,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-10-30",
          "end": "2021-01-18",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-02-12",
          "end": "2021-12-12",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-02-10",
          "end": "2022-10-23",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-01-27",
          "end": "2023-11-19",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": true,
              "statistics_players": true
            },
            "standings": true,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": true
          }
        }
      ]
    },
    {
      "league": {
        "id": 130,
        "name": "Copa Argentina",
        "type": "Cup",
        "logo": "https://media.api-sports.io/football/leagues/130.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2016,
          "start": "2016-05-04",
          "end": "2016-12-15",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2017,
          "start": "2017-02-02",
          "end": "2017-12-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2018,
          "start": "2018-01-19",
          "end": "2018-12-07",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2019,
          "start": "2019-01-16",
          "end": "2019-12-14",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2020,
          "start": "2020-01-15",
          "end": "2021-12-09",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-02-23",
          "end": "2022-10-30",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-02-15",
          "end": "2023-02-15",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 517,
        "name": "Trofeo de Campeones de la Superliga",
        "type": "Cup",
        "logo": "https://media.api-sports.io/football/leagues/517.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2019,
          "start": "2019-12-14",
          "end": "2019-12-14",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2021,
          "start": "2021-12-19",
          "end": "2021-12-19",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2022-11-02",
          "end": "2022-11-06",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-02-22",
          "end": "2023-02-22",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 810,
        "name": "Super Copa",
        "type": "Cup",
        "logo": "https://media-3.api-sports.io/football/leagues/810.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2020,
          "start": "2021-03-05",
          "end": "2021-03-05",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2022,
          "start": "2023-01-20",
          "end": "2023-01-20",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-03-01",
          "end": "2023-03-01",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": false,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 483,
        "name": "Copa de la Superliga",
        "type": "Cup",
        "logo": "https://media.api-sports.io/football/leagues/483.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2020,
          "start": "2020-03-13",
          "end": "2020-12-23",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": true,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        }
      ]
    },
    {
      "league": {
        "id": 906,
        "name": "Reserve League",
        "type": "League",
        "logo": "https://media.api-sports.io/football/leagues/906.png"
      },
      "country": {
        "name": "Argentina",
        "code": "AR",
        "flag": "https://media-3.api-sports.io/flags/ar.svg"
      },
      "seasons": [
        {
          "year": 2022,
          "start": "2022-02-10",
          "end": "2022-11-01",
          "current": false,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": false
          }
        },
        {
          "year": 2023,
          "start": "2023-01-26",
          "end": "2023-11-19",
          "current": true,
          "coverage": {
            "fixtures": {
              "events": true,
              "lineups": false,
              "statistics_fixtures": false,
              "statistics_players": false
            },
            "standings": false,
            "players": false,
            "top_scorers": false,
            "top_assists": false,
            "top_cards": false,
            "injuries": false,
            "predictions": true,
            "odds": true
          }
        }
      ]
    }
  ]
}
"""