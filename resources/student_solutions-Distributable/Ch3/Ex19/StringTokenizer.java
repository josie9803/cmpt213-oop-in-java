/**
 * The string tokenizer class allows an application to break a 
 * string into tokens. 
*/
public class StringTokenizer
{
   /**
         Constructs a string tokenizer for the specified string.
         @param   str            a string to be parsed.
   */
   StringTokenizer(String str)
   {
      tokenizer = new java.util.StringTokenizer(str);
      if (tokenizer.hasMoreTokens())
         currentToken = tokenizer.nextToken();
   }


   /**
         Constructs a string tokenizer for the specified string.
         @param   str            a string to be parsed.
         @param   delim          the delimiters.
   */
   StringTokenizer(String str, String delim)
   {
      tokenizer = new java.util.StringTokenizer(str, delim);
      if (tokenizer.hasMoreTokens())
         currentToken = tokenizer.nextToken();
   }

   /**
         Constructs a string tokenizer for the specified string.
         @param   str            a string to be parsed.
         @param   delim          the delimiters.
         @param   returnDelims   flag indicating whether to return the delimiters
   */
   StringTokenizer(String str, String delim, boolean returnDelims)
   {
      tokenizer = new java.util.StringTokenizer(str, delim, returnDelims);
      if (tokenizer.hasMoreTokens())
         currentToken = tokenizer.nextToken();
   }


   /**
     Returns the current token
     @return the current token
   */
   String getToken()
   {
      return currentToken;
   }

   /**
     Calculates the number of times that this tokenizer's nextToken
     method can be called before it generates an exception.
     @return the number of tokens remaining
   */
   int countTokens()
   {
      return tokenizer.countTokens();
   }

   /**
     Returns the same value as the hasMoreTokens method.
     @return whether more tokens exist
   */
   boolean hasMoreElements()
   {
      return tokenizer.hasMoreElements();
   }

   /**
     Tests if there are more tokens available from this tokenizer's string.
     @return whether more tokens exist
   */
   boolean hasMoreTokens()
   {
      return tokenizer.hasMoreTokens();
   }

   /**
     Returns the same value as the nextToken method, except that its
     declared return value is Object rather than String.  
     @return the next token
   */
   Object nextElement()
   {
      return this.nextToken(); // nextToken sets currentToken
   }

   /**
     Returns the next token from this string tokenizer.
     @return the next token
   */
   String nextToken()
   {
      // The documentation for java.util.StringTokenizer does not specify
      // that nextToken() advances the tokenizer.  Changing that aspect of
      // the behavior of the class would break this class (and lots of
      // other classes.)
      currentToken = tokenizer.nextToken();
      return currentToken;
   }

   /**
     Returns the next token in this string tokenizer's string.
     * @param      delim   the new delimiters.
     * @return     the next token, after switching to the new delimiter set.
   */
   String nextToken(String delim)
   {
      currentToken = tokenizer.nextToken(delim);
      return currentToken;
   }

   private java.util.StringTokenizer tokenizer;
   private String currentToken;
}

