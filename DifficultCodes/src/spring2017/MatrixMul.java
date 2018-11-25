package spring2017;

public class MatrixMul {

	public static void main(String[] args) {
		float[][] A = {{1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f}, {1.0f, 1.0f, 1.0f}};
		float[][] B = {{0.01f, 0.01f, 0.01f}, {0.01f, 0.01f, 0.01f}, {0.01f, 0.01f, 0.01f}};
		float[][] C = new float[3][3];
		int N = 3;
		int b = 1;
		for(int i=0; i < N; i=i+b){
			for(int j=0; j < N; j=j+b){
				for(int k=0; k < N; k=k+b){
					for(int ii=i; ii < i+b; ii++){
						for(int jj=j; jj < j+b; jj++){
							for(int kk=k; kk < k+b; kk++){
								C[ii][jj] = C[ii][jj] + A[ii][kk] * B[kk][jj];
							}
						}
					}
				}
			}
		}
		System.out.println("Matrix result");
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(C[i][j] + "|");
			}
			System.out.println("");
		}
	}
}
