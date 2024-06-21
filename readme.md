# mindbankchallenge
INSTRUCTIONS:
1. I have two executables in this file, first is PremadeDagChallenge, the second is RandomDagChallenge. The first uses a premade DAG I created myself, and is small but more comeplex(Meaning multiple nodes with no parents, more than one node can point to the same child). The latter will generate a Random DAG which will be less complex but will follow the rules of a dag and be unique enough to test against.
2. If using PremadDagChallenge, refer to PremadeDags.PNG to see a visual representation of the DAG being tested. You must also modify the DAGSELECTION variable in this program to select one of the 4 dags to test.
2. Answers to the Coding challenge you send Via the prompt can be found at the very bottom.


I will do my best to outline my process and thoughts concerning this project and my approach to tackling it.


The first thing I did, because I wasn't very familiar with DAGs as a concept was to watch several videos and research how Dags worked and some of the theory behind them. My first inclination was to model the DAG in my program after a tree, since trees are essentially graphs in Java. After a bit more research, I eventually settled on instead modling it as its own class so I had a bit more freedom for any functionality I might have to give it.

Then, I did some reasearch on the Longest Path in Dag algorithm, and how it works. It took me a little while to wrap my head around, but honestly it was pretty fun learning the theory behind it. There seemed to be two ways to accomplish this problem, the first way was a more brute force method using a DFS (Depth First Search), which would have required nested for loops with an operational complexity of (n^2). The other way of solving this was with use of a Topological sort, an algorithm I was familiar with, but hadn't had to use since my College days.

The reason I settled on Topological sorting for my solutions was because it was more efficient and much cleaner of a solution for a couple of reasons. When finding the longest route in a dag, one of the things you have to compute is an Adjacency List for all the Vertex in your Dag, essentially a List of List of Edges, where each inner list is a collection of the edges that lead to a "Child" vertex. Given this Adjacency List, you could then Topologically sort it, which is very useful since it gives you what is essentially an order of "dependencies" for each Vertex.

This topological ordering is very useful for the the longest path problem because of this ordering. Without the ordering, the order in which we check for the pathing would potentially cause a situation where updating the distance between Vertex, but that distance could be updated without revisiting it. This post here helped me understand why it was necessary:
https://stackoverflow.com/questions/27612920/why-is-topological-sort-needed-for-longest-path-in-directed-acyclic-graph, it was one of the many things I came accross in my research.

So, now we had the topological ordering for the adjacencies, I could finally get to work on the longest path algorithm.
The algorithm works thusly:
1. First, you must create an array of some kind to hold values of the the distances from Vertex V(The starting point vertex). The index of this array will hold the distance from the original vertex.
2. Initialize all the distances in that array to -Inf (we used Integer.MIN_VALUE), an easy value to check again. You also have to initialize the index of the searched Vertex to 0, as it will be the starting point for the next part.
3. Then, you work your way through the Topological Ordering, in this case a Stack<Long>
4. First, You pop a value of the ordering, and check to see if the Distance Array[poppedvalue] is either that Integer.MIN_VALUE or not.
5. If that value is 0 or greater, you then update the distance array[ChildValue] with the weight of the edge, assuming that Edge has any child edges to update. (Note: My program does not use weighted edges, it assumes each edge to be of weight 1, but it could easily be changed by providing a weight to the edge class and using that in the computation).
6. Then you pop off the next value of the Topological Ordering stack and repeat steps 4-5.
7. You are left with a Distance array where each index holds the distance from that original node, giving you the answer to your problem.


Some challenges I Had and how I solved them.
1. This is a minor problem I had, but as I like to bounce back and forth between Java and my other languages alot, 
I sometimes forget all the rules Java has for operating on certain variable types. 
As per the prompt given, I decided to make the values of the IDs for the Vertex <Long>, 
but a lot of the operations I had to do required them to be integers. 
I simply had to cast my variables when necessary as they were both primitive types. 
Java has a lot of useful library methods for dealing with numberical values which I very much enjoy.

2. It took me a few hours to wrap my head around the concept of the Topological Sorting + the Longest Path algorithm. 
I am a very visual learner, and simply seeing pseudocode isn't always enough for me to visualise what is happening in an algorithm. 
I used several visual mediums and watch several videos demonstrating the algorithm in a more visual way, which helped me grasp it. 
You also will notice that I like to leave many print statements inside my code, which I will be leaving in there just so you can see my process. 
I like to print out the state of variables throughout the algorithm so I can use them as a debugger. That way I can look at the output for each step of the algorithm and see where it was breaking down, 
making the time it takes to find an issue in the code much faster.

3. The only other problem that I faced that I want to address was the creation of a Dag to begin with, 
since I wasn't given any codebase to start with. 
Modeling a DAG is easy enough but creating a semi-complex one to test against would be a bit more difficult to do, especially if I was test to make sure the algorithm held up under unusual cases. 
To this end, I wrote two executing programs. The first (RandomDagChallenge.java), will generate a randomly generated DAG with a length that you will provide it on the command line. 
This Dag will not be very complex, but it will give you an element of randomness when running the algorithm. 
The second is (PremageDagChallenge.java), this one has a premade DAG which I constructed myself, and while smaller than the random one, is a bit more complex and has an expected output to test against. If I were to keep experimenting with this program, I'd probablly expand the random class to create more complex Dags to test against.



Prompt Answer:
1. Does the solution work for larger graphs?
   -Yes, the algorithm should work for a graph of any size.
2. Can you think of any optomizations?
   -I'm sure I made my code a bit more complex that it needs to be, I like being more descriptive and abstaract in challenges like these more for readability purposes.
   I could certainly shorten the length of the code by condensing certain variable declarations and using 2d arrays instead of the ArrayList class. This would make the code less intuitive in my opinion, but would accomplish essentially the same function practically.
   -I would also probably find a better way to store and represent the distances arrayList.
3. What's the computation Complexity of your solution?
   -If I had done a DFS algorithm, the complexity would have been O(N^2), however since I did a toplogical sorting prior to finding the longest path, the complexity
   is instead O(V+E), where V is the number of Vertex, and E is the number of Edges.
4. Are there any unusual cases that aren't handled?
   -I think this algorithm should cover any properly formatted Dag. The algorithm should also work if the edges are given negative weights, though I haven't tested that exact case very extensively since my edges are not weighted. My test cases try to cover all kinds of premade DAGs with specific cases for all the different types of shapes a DAG can have.