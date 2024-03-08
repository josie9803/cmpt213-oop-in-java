/**
 * A class for testing the StringTokenizer class
 */
class TokenizerTester
{
   /**
    * Creates a tokenizer and uses it
    * @arg args unused
    */
   public static void main(String[] args)
   {
      StringTokenizer t = new StringTokenizer("The cat in the hat");

      System.out.println(t.getToken());
      System.out.println(t.nextToken());
      System.out.println(t.getToken());
      System.out.println(t.getToken());

      while (t.hasMoreTokens())
      {
         System.out.println(t.getToken());
         System.out.println(t.nextToken());
         System.out.println(t.getToken());
      }
   }
}
