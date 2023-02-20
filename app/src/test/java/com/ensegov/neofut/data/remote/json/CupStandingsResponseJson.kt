package com.ensegov.neofut.data.remote.json

const val cupStandingsResponseJson = """
{
  "get": "standings",
  "parameters": {
    "league": "2",
    "season": "2022"
  },
  "errors": [],
  "results": 1,
  "paging": {
    "current": 1,
    "total": 1
  },
  "response": [
    {
      "league": {
        "id": 2,
        "name": "UEFA Champions League",
        "country": "World",
        "logo": "https://media-3.api-sports.io/football/leagues/2.png",
        "flag": null,
        "season": 2022,
        "standings": [
          [
            {
              "rank": 1,
              "team": {
                "id": 492,
                "name": "Napoli",
                "logo": "https://media.api-sports.io/football/teams/492.png"
              },
              "points": 15,
              "goalsDiff": 14,
              "group": "Group A",
              "form": "LWWWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 5,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 20,
                  "against": 6
                }
              },
              "home": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 11,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 9,
                  "against": 3
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 40,
                "name": "Liverpool",
                "logo": "https://media.api-sports.io/football/teams/40.png"
              },
              "points": 15,
              "goalsDiff": 11,
              "group": "Group A",
              "form": "WWWWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 5,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 17,
                  "against": 6
                }
              },
              "home": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 6,
                  "against": 1
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 11,
                  "against": 5
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 194,
                "name": "Ajax",
                "logo": "https://media.api-sports.io/football/teams/194.png"
              },
              "points": 6,
              "goalsDiff": -5,
              "group": "Group A",
              "form": "WLLLL",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 2,
                "draw": 0,
                "lose": 4,
                "goals": {
                  "for": 11,
                  "against": 16
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 5,
                  "against": 9
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 6,
                  "against": 7
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 257,
                "name": "Rangers",
                "logo": "https://media.api-sports.io/football/teams/257.png"
              },
              "points": 0,
              "goalsDiff": -20,
              "group": "Group A",
              "form": "LLLLL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 0,
                "draw": 0,
                "lose": 6,
                "goals": {
                  "for": 2,
                  "against": 22
                }
              },
              "home": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 2,
                  "against": 13
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 0,
                  "against": 9
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 212,
                "name": "FC Porto",
                "logo": "https://media-3.api-sports.io/football/teams/212.png"
              },
              "points": 12,
              "goalsDiff": 5,
              "group": "Group B",
              "form": "WWWWL",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 12,
                  "against": 7
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 4,
                  "against": 5
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 8,
                  "against": 2
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 569,
                "name": "Club Brugge KV",
                "logo": "https://media-3.api-sports.io/football/teams/569.png"
              },
              "points": 11,
              "goalsDiff": 3,
              "group": "Group B",
              "form": "DLDWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 3,
                "draw": 2,
                "lose": 1,
                "goals": {
                  "for": 7,
                  "against": 4
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 3,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 4,
                  "against": 0
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 168,
                "name": "Bayer Leverkusen",
                "logo": "https://media-3.api-sports.io/football/teams/168.png"
              },
              "points": 5,
              "goalsDiff": -4,
              "group": "Group B",
              "form": "DDLLW",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 1,
                "draw": 2,
                "lose": 3,
                "goals": {
                  "for": 4,
                  "against": 8
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 2,
                  "against": 5
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 530,
                "name": "Atletico Madrid",
                "logo": "https://media.api-sports.io/football/teams/530.png"
              },
              "points": 5,
              "goalsDiff": -4,
              "group": "Group B",
              "form": "LDDLL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 1,
                "draw": 2,
                "lose": 3,
                "goals": {
                  "for": 5,
                  "against": 9
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 4,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 1,
                  "against": 6
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 157,
                "name": "Bayern Munich",
                "logo": "https://media-3.api-sports.io/football/teams/157.png"
              },
              "points": 18,
              "goalsDiff": 16,
              "group": "Group C",
              "form": "WWWWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 6,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 18,
                  "against": 2
                }
              },
              "home": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 9,
                  "against": 0
                }
              },
              "away": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 9,
                  "against": 2
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 505,
                "name": "Inter",
                "logo": "https://media-3.api-sports.io/football/teams/505.png"
              },
              "points": 10,
              "goalsDiff": 3,
              "group": "Group C",
              "form": "LWDWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 3,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 10,
                  "against": 7
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 5,
                  "against": 2
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 5,
                  "against": 5
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 529,
                "name": "Barcelona",
                "logo": "https://media-3.api-sports.io/football/teams/529.png"
              },
              "points": 7,
              "goalsDiff": 0,
              "group": "Group C",
              "form": "WLDLL",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 2,
                "draw": 1,
                "lose": 3,
                "goals": {
                  "for": 12,
                  "against": 12
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 8,
                  "against": 7
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 4,
                  "against": 5
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 567,
                "name": "Plzen",
                "logo": "https://media.api-sports.io/football/teams/567.png"
              },
              "points": 0,
              "goalsDiff": -19,
              "group": "Group C",
              "form": "LLLLL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 0,
                "draw": 0,
                "lose": 6,
                "goals": {
                  "for": 5,
                  "against": 24
                }
              },
              "home": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 4,
                  "against": 10
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 1,
                  "against": 14
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 47,
                "name": "Tottenham",
                "logo": "https://media.api-sports.io/football/teams/47.png"
              },
              "points": 11,
              "goalsDiff": 2,
              "group": "Group D",
              "form": "WDWDL",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 3,
                "draw": 2,
                "lose": 1,
                "goals": {
                  "for": 8,
                  "against": 6
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 6,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 3
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 169,
                "name": "Eintracht Frankfurt",
                "logo": "https://media.api-sports.io/football/teams/169.png"
              },
              "points": 10,
              "goalsDiff": -1,
              "group": "Group D",
              "form": "WWLDW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 3,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 7,
                  "against": 8
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 5,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 228,
                "name": "Sporting CP",
                "logo": "https://media.api-sports.io/football/teams/228.png"
              },
              "points": 7,
              "goalsDiff": -1,
              "group": "Group D",
              "form": "LDLLW",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 2,
                "draw": 1,
                "lose": 3,
                "goals": {
                  "for": 8,
                  "against": 9
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 3,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 5,
                  "against": 5
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 81,
                "name": "Marseille",
                "logo": "https://media.api-sports.io/football/teams/81.png"
              },
              "points": 6,
              "goalsDiff": 0,
              "group": "Group D",
              "form": "LLWWL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 2,
                "draw": 0,
                "lose": 4,
                "goals": {
                  "for": 8,
                  "against": 8
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 5,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 3,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 49,
                "name": "Chelsea",
                "logo": "https://media.api-sports.io/football/teams/49.png"
              },
              "points": 13,
              "goalsDiff": 6,
              "group": "Group E",
              "form": "WWWWD",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 10,
                  "against": 4
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 6,
                  "against": 2
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 4,
                  "against": 2
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 489,
                "name": "AC Milan",
                "logo": "https://media-3.api-sports.io/football/teams/489.png"
              },
              "points": 10,
              "goalsDiff": 5,
              "group": "Group E",
              "form": "WWLLW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 3,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 12,
                  "against": 7
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 7,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 5,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 571,
                "name": "Red Bull Salzburg",
                "logo": "https://media-3.api-sports.io/football/teams/571.png"
              },
              "points": 6,
              "goalsDiff": -4,
              "group": "Group E",
              "form": "LLDWD",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 1,
                "draw": 3,
                "lose": 2,
                "goals": {
                  "for": 5,
                  "against": 9
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 3,
                  "against": 3
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 2,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 6
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 620,
                "name": "Dinamo Zagreb",
                "logo": "https://media-3.api-sports.io/football/teams/620.png"
              },
              "points": 4,
              "goalsDiff": -7,
              "group": "Group E",
              "form": "LLDLL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 1,
                "draw": 1,
                "lose": 4,
                "goals": {
                  "for": 4,
                  "against": 11
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 5
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 2,
                  "against": 6
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 541,
                "name": "Real Madrid",
                "logo": "https://media.api-sports.io/football/teams/541.png"
              },
              "points": 13,
              "goalsDiff": 9,
              "group": "Group F",
              "form": "WLDWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 15,
                  "against": 6
                }
              },
              "home": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 9,
                  "against": 2
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 6,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 173,
                "name": "RB Leipzig",
                "logo": "https://media.api-sports.io/football/teams/173.png"
              },
              "points": 12,
              "goalsDiff": 4,
              "group": "Group F",
              "form": "WWWWL",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 13,
                  "against": 9
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 7,
                  "against": 7
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 0,
                "lose": 1,
                "goals": {
                  "for": 6,
                  "against": 2
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 550,
                "name": "Shakhtar Donetsk",
                "logo": "https://media-3.api-sports.io/football/teams/550.png"
              },
              "points": 6,
              "goalsDiff": -2,
              "group": "Group F",
              "form": "LDDLD",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 1,
                "draw": 3,
                "lose": 2,
                "goals": {
                  "for": 8,
                  "against": 10
                }
              },
              "home": {
                "played": 3,
                "win": 0,
                "draw": 2,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 6
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 6,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 247,
                "name": "Celtic",
                "logo": "https://media.api-sports.io/football/teams/247.png"
              },
              "points": 2,
              "goalsDiff": -11,
              "group": "Group F",
              "form": "LDLLD",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 0,
                "draw": 2,
                "lose": 4,
                "goals": {
                  "for": 4,
                  "against": 15
                }
              },
              "home": {
                "played": 3,
                "win": 0,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 1,
                  "against": 6
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 1,
                "lose": 2,
                "goals": {
                  "for": 3,
                  "against": 9
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 50,
                "name": "Manchester City",
                "logo": "https://media.api-sports.io/football/teams/50.png"
              },
              "points": 14,
              "goalsDiff": 12,
              "group": "Group G",
              "form": "WDDWW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 14,
                  "against": 2
                }
              },
              "home": {
                "played": 3,
                "win": 3,
                "draw": 0,
                "lose": 0,
                "goals": {
                  "for": 10,
                  "against": 2
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 4,
                  "against": 0
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 165,
                "name": "Borussia Dortmund",
                "logo": "https://media-3.api-sports.io/football/teams/165.png"
              },
              "points": 9,
              "goalsDiff": 5,
              "group": "Group G",
              "form": "DDDWL",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 2,
                "draw": 3,
                "lose": 1,
                "goals": {
                  "for": 10,
                  "against": 5
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 4,
                  "against": 1
                }
              },
              "away": {
                "played": 3,
                "win": 1,
                "draw": 1,
                "lose": 1,
                "goals": {
                  "for": 6,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 536,
                "name": "Sevilla",
                "logo": "https://media-3.api-sports.io/football/teams/536.png"
              },
              "points": 5,
              "goalsDiff": -6,
              "group": "Group G",
              "form": "LWDLD",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 1,
                "draw": 2,
                "lose": 3,
                "goals": {
                  "for": 6,
                  "against": 12
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 4,
                  "against": 8
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 2,
                "lose": 1,
                "goals": {
                  "for": 2,
                  "against": 4
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 400,
                "name": "FC Copenhagen",
                "logo": "https://media.api-sports.io/football/teams/400.png"
              },
              "points": 3,
              "goalsDiff": -11,
              "group": "Group G",
              "form": "DLDLD",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 0,
                "draw": 3,
                "lose": 3,
                "goals": {
                  "for": 1,
                  "against": 12
                }
              },
              "home": {
                "played": 3,
                "win": 0,
                "draw": 3,
                "lose": 0,
                "goals": {
                  "for": 1,
                  "against": 1
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 0,
                  "against": 11
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ],
          [
            {
              "rank": 1,
              "team": {
                "id": 211,
                "name": "Benfica",
                "logo": "https://media.api-sports.io/football/teams/211.png"
              },
              "points": 14,
              "goalsDiff": 9,
              "group": "Group H",
              "form": "WWDDW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 16,
                  "against": 7
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 7,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 9,
                  "against": 3
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 2,
              "team": {
                "id": 85,
                "name": "Paris Saint Germain",
                "logo": "https://media.api-sports.io/football/teams/85.png"
              },
              "points": 14,
              "goalsDiff": 9,
              "group": "Group H",
              "form": "WWDDW",
              "status": "same",
              "description": "Promotion - Champions League (Play Offs: 1/8-finals)",
              "all": {
                "played": 6,
                "win": 4,
                "draw": 2,
                "lose": 0,
                "goals": {
                  "for": 16,
                  "against": 7
                }
              },
              "home": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 10,
                  "against": 4
                }
              },
              "away": {
                "played": 3,
                "win": 2,
                "draw": 1,
                "lose": 0,
                "goals": {
                  "for": 6,
                  "against": 3
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 3,
              "team": {
                "id": 496,
                "name": "Juventus",
                "logo": "https://media-3.api-sports.io/football/teams/496.png"
              },
              "points": 3,
              "goalsDiff": -4,
              "group": "Group H",
              "form": "LLLWL",
              "status": "same",
              "description": "Promotion - Europa League (Play Offs: 1/16-finals)",
              "all": {
                "played": 6,
                "win": 1,
                "draw": 0,
                "lose": 5,
                "goals": {
                  "for": 9,
                  "against": 13
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 5,
                  "against": 5
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 4,
                  "against": 8
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            },
            {
              "rank": 4,
              "team": {
                "id": 4195,
                "name": "Maccabi Haifa",
                "logo": "https://media.api-sports.io/football/teams/4195.png"
              },
              "points": 3,
              "goalsDiff": -14,
              "group": "Group H",
              "form": "LLWLL",
              "status": "same",
              "description": null,
              "all": {
                "played": 6,
                "win": 1,
                "draw": 0,
                "lose": 5,
                "goals": {
                  "for": 7,
                  "against": 21
                }
              },
              "home": {
                "played": 3,
                "win": 1,
                "draw": 0,
                "lose": 2,
                "goals": {
                  "for": 4,
                  "against": 9
                }
              },
              "away": {
                "played": 3,
                "win": 0,
                "draw": 0,
                "lose": 3,
                "goals": {
                  "for": 3,
                  "against": 12
                }
              },
              "update": "2022-12-12T00:00:00+00:00"
            }
          ]
        ]
      }
    }
  ]
}
"""