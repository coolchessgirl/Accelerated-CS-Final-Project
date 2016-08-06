   /**
    * Finds a solution for the Instant Insanity puzzle. When four cubes, having
    * sides with the colors red, green, white and blue are given to the program,
    * it will run through possible orientations of a stack of these four cubes until
    * it has'stacked' the four cubes into a tower where each color is only
    * showing once on each side of the tower.

    * @author Shreya Vinjamuri
    */
   public class PuzzleSolver {

    /**
	 * Uses recursion to run through possible orientations by changing cubePosition
    * @param cubes the array of cubes with colors entered by user
	 * @param cubePosition the cube that is being placed on the stack now
	 */
      public void getSolution(Cube[] cubes, int cubePosition) {

         if (cubePosition > cubes.length) {	
    
            if (verify(cubes))	         
            {
               printCubes(cubes);
            }
         }
         else {
            for (int pairNum = 1; pairNum <= 3; pairNum++)	{	 
            
               if (cubePosition == 1)			
                  getSolution(cubes, cubePosition+1);
               else  {								
                  for (int rotation = 1; rotation <= 4; rotation++) {	
                     getSolution(cubes, cubePosition+1);
                     cubes[cubePosition-1].turnLeft();
                  }
               
                  cubes[cubePosition-1].flip180();
               
                  for (int rotation = 1; rotation <= 4; rotation++) {	
                     getSolution(cubes, cubePosition+1);
                     cubes[cubePosition-1].turnLeft();
                  }
               
                  cubes[cubePosition-1].flip180();
               }
            
               cubes[cubePosition-1].turnLeft();
               cubes[cubePosition-1].flip90();
            }
         }
      }
      
	 /**
	 * Returns true if each color is only showing once on each side of the stack of four cubes
    * (cube positions are valid)
	 * @return true if each color is only showing once on each side of the stack of four cubes.
	 */
      public boolean verify(Cube[] cubeSet) {
      
         boolean isCorrect = true;
      
         for (int i = 0; i < 3 && isCorrect; i++) {
            for (int j = 1; j < 4 && isCorrect; j++) {
               if (j > i) {
                  isCorrect = 
                     	! (cubeSet[i].getRightColor().equals(cubeSet[j].getRightColor()))
                     	&& ! (cubeSet[i].getLeftColor().equals(cubeSet[j].getLeftColor()))
                     	&& ! (cubeSet[i].getFrontColor().equals (cubeSet[j].getFrontColor()))
                     	&& !(cubeSet[i].getBackColor().equals(cubeSet[j].getBackColor()));
               }
            }
         
         }
      
         return isCorrect;
      
      }
    /**
    * Prints the color combinations of each cube in the solution 
    * Sets solution array in CubePanel class to color combinations in the solution
    * (prints front color of cube one, back color of cube one, etc.)
    * @param cubeSet a set of cubes with respective colors 
    * @return returns color combinations of cubes in the solution
    */
      public String[][] printCubes(Cube[] cubeSet) {
         String[][] array = new String[4][6];
         for (int i = 0; i < cubeSet.length; i++) {
         
            System.out.println(i
               	             + " Front color: "+ cubeSet[i].getFrontColor()
               	             + " Back color: " + cubeSet[i].getBackColor()
               	             + " Left color: " + cubeSet[i].getLeftColor()
               	             + " Right color: "+ cubeSet[i].getRightColor()
               	             + " Top color: " + cubeSet[i].getTopColor() 
               	             + " Bottom color: "+ cubeSet[i].getBottomColor());
            CubePanel.solution[i][0] = cubeSet[i].getBackColor();  
            CubePanel.solution[i][1] = cubeSet[i].getLeftColor();
            CubePanel.solution[i][2] = cubeSet[i].getTopColor();
            CubePanel.solution[i][3] = cubeSet[i].getRightColor();
            CubePanel.solution[i][4] = cubeSet[i].getFrontColor();
            CubePanel.solution[i][5] = cubeSet[i].getBottomColor();                
         }
         return array;
      
      }
   	
   
   }
   
   		
   
   		
   
   		
   