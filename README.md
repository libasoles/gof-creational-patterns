# GoF Creational patterns

The book `Design Patters`, by the _Gang of Four_, exemplifies the creational patterns starting with a single maze (=labyrinth) domain.

I'm modelling quite the same example they wrote in C++, but in Java.

Also, I wanted to model this with _TDD_, taking in consideration their UML design (actually, it was OMT notation), but growing from scratch. That was fascinating, because I could feel the need of creational patterns even in the tests. 

## Domain

Basically, you have a Labyrinth, composed by rooms. All rooms have four sides. And sides could be either another room, a door, or a wall.

Sides are represented by north, south, east and west directions.

A door can be either open or closed. If closed, you snap your nose onto it, as you would in a wall.

There's no need to actually model a player, that's out of scope. 

