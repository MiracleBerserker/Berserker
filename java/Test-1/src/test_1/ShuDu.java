package test_1;

public class ShuDu {
    public boolean isValid(int[][] a, int i, int j, int v){
        //行是否冲突
        for(int jj=0;jj<9;jj++){
            if(a[i][jj]==v)
                return false;
        }
        //列是否冲突
        for(int ii=0;ii<9;ii++){
            if(a[ii][j]==v)
                return false;
        }
        //找错ij对应坐标的点
        int ii = 0, jj = 0;
        boolean flag = true;
        for(ii=0;ii<3&&flag;ii++){
            if(!(i>=ii*3&&i<3*(ii+1)))
                continue;
            for(jj=0;jj<3;jj++){
                if(j>=jj*3&&j<3*(jj+1)){
                    flag = false;
                    break;
                }
            }
        }
        ii--;
        //是否和九宫格冲突
        for(int iii=3*ii;iii<3*(ii+1);iii++){           
            for(int jjj=3*jj;jjj<3*(jj+1);jjj++){
                if(a[iii][jjj]==v)
                    return false;
            }
        }
        return true;
    }
    //打印
    public void printMatrix(int[][] a){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    //回溯法
    public void shuDu(int[][] a, int i, int j){
        if(i==8&&j>=9){
            printMatrix(a);
            return;
        }
        if(j==9){
            j=0;
            i++;
        }
        if(a[i][j]==0){
            for(int k=1;k<=9;k++){
                if(isValid(a,i,j,k)){
                    a[i][j] = k;
                    //向下继续找
                    shuDu(a,i,j+1);
                    //如果没有找到全部答案将a[i][j]的值恢复
                    a[i][j] = 0;
                }
            }
        }else{
            shuDu(a,i,j+1);
        }
    }
public static void main(String[] args) {
        ShuDu sd = new ShuDu();
int[][] s1 = { 
         {7,6,1,0,3,0,0,2,5}, 
         {3,5,0,0,0,8,1,0,7}, 
         {0,2,0,0,0,7,0,3,4}, 
         {0,0,9,0,0,6,3,7,8}, 
         {0,0,3,2,7,9,5,0,0}, 
         {5,7,0,3,0,0,9,0,2}, 
         {1,9,5,7,6,0,0,0,0},  
         {8,3,2,4,0,0,7,6,0}, 
         {6,4,7,0,1,0,2,5,0}};
int s2[][]={
        {0,0,5,0,0,0,2,0,0},
        {0,0,0,4,0,6,0,0,0},
        {7,0,0,0,1,0,0,0,6},
        {0,7,0,0,0,0,0,1,0},
        {0,0,4,0,3,0,8,0,0},
        {0,8,0,0,0,0,0,6,0},
        {6,0,0,0,9,0,0,0,5},
        {0,0,0,2,0,8,0,0,0},
        {0,0,2,0,0,0,3,0,0}};
      System.out.println("###################第一题######################");
      sd.shuDu(s1, 0, 0);
      System.out.println("###################第二题######################");
      sd.shuDu(s2, 0, 0);
	}
}
