@SuppressWarnings("all")
public class Matrix {
    private double data[][];
    public Matrix() {
        data = null;
    }

    public Matrix(int rows, int cols) {
        try {
            if (rows < 1 || cols < 1) {
                throw new IllegalArgumentException();
            }
            data = new double[rows][cols];
        }catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }

    public Matrix(double data[][]) {
        try {
            if (data == null){
                throw new IllegalArgumentException();
            }
            this.data = data;
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }

    public int getRows() {
        int rows;
        rows = data.length;
        return rows;
    }

    public int getCols() {
        int cols;
        cols = data[0].length;
        return cols;
    }

    public double getData(int row, int col) {
        try {
            if (row > this.getRows() || col > this.getCols() || row < 0 || col<0){
                throw new IllegalIndexException();
            }
            return this.data[row][col];
        }catch (IllegalIndexException e) {
            System.out.println(e.toString());
            return 0;
        }
    }

    public void setData(int row, int col, double value) {
        try {
            if (row >= this.getRows() || col >= this.getCols() || row < 0 || col<0){
                throw new IllegalIndexException();
            }
            this.data[row][col] = value;
        }catch (IllegalIndexException e) {
            System.out.println(e.toString());
        }
    }

    public Matrix multiply(Matrix m) {
        try {
            if (m == null || this.getCols() != m.getRows() || this == null) {
                throw new MatrixMultiplicationException();
            }
            double[][] mix = new double[this.getRows()][m.getCols()];
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < m.getCols(); j++) {
                    for (int k = 0; k < this.getCols(); k++) {
                        mix[i][j] = mix[i][j] + this.getData(i, k) * m.getData(k, j);
                    }
                }
            }
            Matrix result = new Matrix(mix);
            return result;
        }catch (MatrixMultiplicationException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Matrix) {
            Matrix m = (Matrix) o;
            if (this.getRows() == m.getRows()) {
                if (this.getCols() == m.getCols()) {
                    for (int i = 0; i < m.getRows(); i++){
                        for (int j = 0; j <m.getCols(); j++){
                            if (this.getData(i, j) != m.getData(i ,j)){
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void toStringv() {
        if (this != null){
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getCols(); j++) {
                    if (j == 0) {
                        System.out.print("[ ");
                    }
                    System.out.print(this.getData(i, j)+" ");
                    if (j == this.getCols() - 1) {
                        System.out.print("]");
                    }
                }
                System.out.printf("\n");
            }
        }
        else {
            System.out.println("null");
        }
    }
}
