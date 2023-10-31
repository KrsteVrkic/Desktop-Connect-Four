package four;

enum Player {

    X, O;

    @Override
    public String toString() {
        return super.toString();
    }

    public Player nextPlayer() {
        if (this == X) {
            return O;
        } else {
            return X;
        }
    }
}
