package com.example.snhelloworldandroidtest;


/*
 * class Fraction:
 * 	__init__(self, numerator, denominator):
 *   self.numerator = numerator
 *   self.denominator = denominator
 */
public class Fraction
{
    //fields - variables associated with a class
    long numerator;
    long denominator;

    //constructor
    public Fraction(long numerator, long denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(String f)
    {
        //f is in the format of "numerator/denominator" so
        //somehow (using only what we have learned in class)
        //divide the string and set the numerator and denominator
        String numString = "";
        int pos = 0;
        while(f.charAt(pos) != '/')
        {
            numString = numString + f.charAt(pos);
            pos = pos + 1;
        }

        pos = pos + 1; //skips past the /
        String denomString = "";
        while(pos < f.length())
        {
            denomString = denomString + f.charAt(pos);
            pos = pos + 1;
        }
        this.numerator = this.stringToLong(numString);
        this.denominator = this.stringToLong(denomString);
    }

    //methods
    public void add(Fraction f)
    {
        //adds f to "this" Fraction and returns
        //a new Fraction object that is the sum
        //of the two
        long denom = this.denominator * f.denominator;
        long num = (this.denominator * f.numerator) +
                (f.denominator * this.numerator);
        this.denominator = denom;
        this.numerator = num;
    }

    public void reduceEuclidean()
    {
        long smallest = this.numerator;
        long largest = this.denominator;
        if(this.denominator < smallest)
        {
            smallest = this.denominator;
            largest = this.numerator;
        }
        long remainder = largest % smallest;
        while(remainder > 0)
        {
            largest = smallest;
            smallest = remainder;
            remainder = largest % smallest;
        }
        if(remainder == 0)
        {
            this.numerator = this.numerator / smallest;
            this.denominator = this.denominator / smallest;
            return;
        }
    }

    public void reduce()
    {
        long smallest = this.numerator;
        if(this.denominator < smallest)
        {
            smallest = this.denominator;
        }
        //smallest is the smaller of the 2 numbers
        //Find the GCD (Greatest Common Divisor)
        while(smallest >= 1)
        {
            if(this.numerator % smallest == 0 &&
                    this.denominator % smallest == 0)
            {
                //we have found the GCD, it is smallest
                this.numerator = this.numerator / smallest;
                this.denominator = this.denominator / smallest;
                return; //I have found and applied the GCD, so kill the method
            }
            else
            {
                smallest = smallest - 1;
            }
        }
    }

    private long stringToLong(String dec)
    {
        long sum = 0;
        long place = 1;
        String map = "0123456789";
        for(int i = dec.length()-1; i >= 0; i = i - 1)
        {
            sum = sum + (place * map.indexOf(dec.charAt(i)));
            place = place * 10;
        }
        return sum;
    }
    //this overrides the default toString method we inherited
    //from the Object class and allows us to do our own thing
    //historic function - returns a value
    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }

    //historic procedure - does NOT return a value
    public void display()
    {

        System.out.println(this.numerator + "/" + this.denominator);
    }

}