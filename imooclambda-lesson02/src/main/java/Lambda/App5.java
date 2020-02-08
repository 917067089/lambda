package Lambda;

public class App5 {
    public static void main(String[] args) {
        IMarkUp mu = new IMarkUp() {
            @Override
            public void markUp(String msg) {
                System.out.println(msg);
            }
        };
        mu.markUp("sss");
        /**
         * 原先
         *public class Lambda.App5 {
         *   public Lambda.App5();
         *   private static void lambda$main$0(java.lang.String);
         * }
         *  public class Lambda.App5 {
         *  public Lambda.App5(){
             *
             *  }
             *   private static void lambda$main$0(java.lang.String message){
             *       System.out.pringln(messsage);
             *   }
         *   }

         *
         *
         * final class Lambda.App5$1 implements Lambda.IMarkUp {
         *   Lambda.App5$1();
         *   public void markUp(java.lang.String);
         * }
         *
         * final class Lambda.App5$1 implements Lambda.IMarkUp {
         *      Lambda.App5$1(){
         *
         *      }
         *      public void markUp(java.lang.String msg){
         *          Lambda.App5$1（msg）
         *      }
         * }
         * final class App5$Lambda$1 implements IMarkUp{
         *     private App%$$Lambda$1(){
         *
         *     }
         *     public void markUp(java.lang.String){
         *         App5.$Lambda$()(msg);
         *     }
         * }
         */
        IMarkUp su1 = (msg) -> System.out.println(msg);
        su1.markUp("lammbda");
//        new App5$Lambda$1().markUp("lambda");
    }

}
interface IMarkUp{
    void markUp(String msg);
}
