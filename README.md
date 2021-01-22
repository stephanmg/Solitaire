# Peg solitaire

First of all, this is an explorative respectively recreational programming project to gain more experience with Kotlin. You can just go ahead and download the compiled executable and deployed to Bintray to start playing the classic Peg solitaire game. For the interest reader, see the introduction below and the upcoming features requested by users.

## Introduction
Peg Solitaire is a well-known single-player board game involving moving pegs between holes in the board. It is said to date back as far as to August 1687 and that Louis XIV or known as Louis the Great was a passionate player. Some sets use sophisticated marble or glass boards for pegs and indentations, others use wooden or plastic boards. In the UK or India it is also known under the synonyms Solitaire or Brainvita. As for the game play a valid move a peg needs to jump orthogonally over an adjacent peg into a hole two positions away which will remove the jumped peg. Depending on the board size and configuration multiple solutions, i.e. sequences of moves, may exist or not, and has attracted many recreational mathematicians and hobbyist around the world, see also game play and board configurations on [wikipedia](https://en.wikipedia.org/wiki/Peg_solitaire) and for a mathematical treatment of the game compare the website on [recmath](http://recmath.org/pegsolitaire) which contains a great deal of monographs and books.

Now using Kotlin and JavaFX/TorandoFX a 2D peg solitaire has been implemented, see code below and compiled binaries on Bintray (fat jar). For upcoming features, see the list below and feel free to open an Issue for additional features. 

Solutions are calculated by a level-based DFS which indicate to the user if a solution can still be reached or the game is lost. The user can undo moves and redo moves and save and load the game state. Two boards are available, the classic 33-hole board also known as English board and a 9 by 9 square board. Feel free to feature request another type of board.

---

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c1895090a5fe4f009f7835d0f7d5e1ca)](https://app.codacy.com/manual/stephan_5/Solitaire?utm_source=github.com&utm_medium=referral&utm_content=stephanmg/Solitaire&utm_campaign=Badge_Grade_Settings)
[![Build Status](https://travis-ci.org/stephanmg/Solitaire.svg?branch=master)](https://travis-ci.org/stephanmg/Solitaire)
[![Download](https://api.bintray.com/packages/stephanmg/Solitaire/0.0.1-nightly/images/download.svg) ](https://bintray.com/stephanmg/Solitaire/0.0.1-nightly/_latestVersion)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-magenta.svg)](https://www.gnu.org/licenses/gpl-3.0)

## Features requests (Ordered by increasing priority)
- Make look GUI more pretty, exchange JavaFX with TornadoFX, change board material
- Adapt 2D solitaire to 3D solitaire
- Serialize history of commands to allow for a replay of a game
- Add KDoc and unit testing
- Add a Javalin webinterface and console UI to play solitaire games
- Support multiple game states

## Useful links
- https://github.com/openjfx/javafx-gradle-plugin
- https://github.com/edvin/tornadofx
- https://github.com/tipsy/javalin
- https://en.wikipedia.org/wiki/Peg_solitaire
- http://recmath.org/pegsolitaire
