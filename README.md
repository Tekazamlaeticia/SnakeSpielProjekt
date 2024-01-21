Snake Game mit Model-View-Controller (MVC) Architektur
Einleitung
Dieses Projekt implementiert das klassische Snake-Spiel unter Verwendung des Model-View-Controller (MVC)-Designmusters. Das Spiel wurde in der Programmiersprache Java unter Verwendung des Processing-Frameworks erstellt.

Architektur
ViewSnake
Die ViewSnake-Klasse ist für die Anzeige des Spiels verantwortlich. Sie umfasst den Titelbildschirm, die Schlange, das Essen (Apple und Mushroom), das schlechte Essen in schwarzer Farbe und den Game-Over-Bildschirm. Die Schlange und das Essen haben verschiedene Farben. Die View verwendet die ControlP5-Bibliothek, um eine Schaltfläche am Ende des Spiels zur Neustartfunktion bereitzustellen.

ModelSnake
Die ModelSnake-Klasse enthält die Spiellogik und Daten, einschließlich der Position der Schlange, des Essens und des Spielstatus. Die Klasse verwendet eine ArrayList für die x- und y-Koordinaten der Schlange und die Math-Klasse zur Generierung zufälliger Koordinaten für das Essen. Eine innere SnakeThread-Klasse steuert die Bewegung der Schlange. Die Klasse implementiert die Methode game(), um den Spielzustand zu aktualisieren, Punkte zu zählen und die Position der Schlange und des Essens zu aktualisieren. Zusätzlich gibt es die Methode getRandomNumber(), um zufällige Koordinaten für das Essen zu generieren.

ControllerSnake
Die ControllerSnake-Klasse implementiert die IController-Schnittstelle und steuert den Spielfluss. Sie verarbeitet Benutzereingaben, aktualisiert das Modell und die Ansicht. Die Klasse verwendet eine Richtungsvariable, um die Schlange zu steuern. Sie kommuniziert eng mit der ModelSnake-Klasse und der IView-Schnittstelle.
