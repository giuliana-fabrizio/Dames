# Jeu de Dames

Projet personnel réalisé sur mon temps libre : conception et développement d’un jeu de dames.

### **⚙️ Outils de développement**
* Langage : Java
* Librairie : JavaFX
* IDE : IntelliJ Idea

### **🎮 Fonctionnalités**
* Plateau de jeu interactif en 2D
* Gestion des déplacements et captures
* Tour par tour automatique entre les joueurs

<!-- ```js
int destY = this.provY - 1;
if (this.player == 1 && paint.equals(Color.BLACK)) {
    for (int destX = this.provX - 1; (destX >= 0) && (destY >= 0) && (!samePlayer(destX, destY)); destX--) { // en haut droite
        if (canGo(destX, destY))
            this.list.add(new Point2D(destX, destY));
        else if (canGo(destX - 1, destY - 1)) {
            this.list.add(new Point2D(destX - 1, destY - 1));
            this.eatList.add(new Point2D(destX, destY));
            this.eatList.add(new Point2D(destX - 1, destY - 1));
            destX = 0;
        }
        else
            destX = 0;
        destY -= 1;
    }

    destY = this.provY - 1;
    for (int destX = this.provX + 1; (destX < this.view.getTab().length) && (destY >= 0) && (!samePlayer(destX, destY)); destX++) { // en haut gauche
        if (canGo(destX, destY))
            this.list.add(new Point2D(destX, destY));
        else if (canGo(destX + 1, destY - 1)) {
            this.list.add(new Point2D(destX + 1, destY - 1));
            this.eatList.add(new Point2D(destX, destY));
            this.eatList.add(new Point2D(destX + 1, destY - 1));
            destY = 0;
        }
        else
            destY = 0;
        destY -= 1;
    }
}
else if (this.player == 2 && paint.equals(Color.WHITESMOKE)) {
    destY = this.provY + 1;
    for (int destX = this.provX - 1; (destX >= 0) && (destY < this.view.getTab().length) && (!samePlayer(destX, destY)); destX--) { // en bas gauche
        if (canGo(destX, destY))
            this.list.add(new Point2D(destX, destY));
        else if (canGo(destX - 1, destY + 1)) {
            this.list.add(new Point2D(destX - 1, destY + 1));
            this.eatList.add(new Point2D(destX, destY));
            this.eatList.add(new Point2D(destX - 1, destY + 1));
            destX = 0;
        }
        else
            destX = 0;
        destY += 1;
    }

    destY = this.provY + 1;
    for (int destX = this.provX + 1; (destX < this.view.getTab().length) && (destY < this.view.getTab().length) && (!samePlayer(destX, destY)); destX++) { // en bas droite
        if (canGo(destX, destY))
            this.list.add(new Point2D(destX, destY));
        else if (canGo(destX + 1, destY + 1)) {
            this.list.add(new Point2D(destX + 1, destY + 1));
            this.eatList.add(new Point2D(destX, destY));
            this.eatList.add(new Point2D(destX + 1, destY + 1));
            destY = this.view.getTab().length;
        }
        else
            destY = this.view.getTab().length;
        destY += 1;
    }
}
``` -->