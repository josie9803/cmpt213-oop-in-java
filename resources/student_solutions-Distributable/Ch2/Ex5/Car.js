// A constructor for car objects

function Car(aLevel, anEfficiency)
{
   // Line terminators are not allowed immediately after return
   // Make sure the { is on the same line as the return
   return {  
      level: aLevel,

      efficiency: anEfficiency,

      addFuel: function (fuel) {this.level = this.level + fuel},

      getLevel: function () {return this.level},

      drive: function (miles) {
         if ( (miles / this.efficiency) > this.level)
         {
            print("Out of gas after " + this.level * this.efficiency 
                  + " miles.")
            this.level = 0
         }
         else
            this.level = this.level - (miles/this.efficiency) }
   }
}

