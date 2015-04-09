### Overview ###

LinLogLayout is a simple program for computing graph layouts
(positions of graph nodes in two- or three-dimensional space)
and graph clusterings.
It reads a graph from a file, computes a layout and a clustering, writes
the layout and the clustering to a file, and displays them in a dialog.
LinLogLayout can be used to identify groups of densely connected nodes
in graphs, like communities of friends or collaborators in social networks,
related documents in hyperlink structures (e.g. web graphs),
cohesive subsystems in software systems, etc.
With a change of a parameter in the `main` method,
it can also compute classical "nice" (i.e. readable) force-directed layouts.

The program is primarily intended as a demo for the use of its core layouter
and clusterer classes `MinimizerBarnesHut`, `MinimizerClassic`,
and `OptimizerModularity`.  While `MinimizerBarnesHut` is faster, `MinimizerClassic`
is simpler and not limited to a maximum of three dimensions.

LinLogLayout optimizes LinLog and related energy models to compute layouts,
and Newman and Girvan's Modularity to compute clusterings.  For more information about LinLog and Modularity, see
  * A. Noack. [Energy Models for Graph Clustering](http://jgaa.info/volume11.html), _Journal of Graph Algorithms and Applications_, 11(2):453-480, 2007.
  * M. E. J. Newman. [Analysis of Weighted Networks](http://arxiv.org/abs/cond-mat/0407503), _Physical Review E_, 70:056131, 2004.
  * A. Noack. [Modularity Clustering is Force-Directed Layout](http://arxiv.org/abs/0807.4052), _Physical Review E_, 79:026102, 2009.


### Usage ###

**Usage:** `java LinLogLayout <dim> <inputfile> <outputfile>`
computes a `<dim>`-dimensional layout and a clustering for the graph
in `<inputfile>`, writes the layout and the clustering into `<outputfile>`,
and displays (the first 2 dimensions of) the layout and the clustering.
`<dim>` must be 2 or 3.

**Input file format:**
Each line represents an edge and has the format `<source> <target> <nonnegative real weight>`, where the weight is optional and defaults to 1.0.

**Output file format:**
`<node> <x-coordinate> <y-coordinate> <z-coordinate (0.0 for 2D)> <cluster>`

**Example:**
`java -cp bin LinLogLayout 2 examples/WorldImport1999.el WorldImport1999.lc`


### Example ###

![http://linloglayout.googlecode.com/svn/trunk/examples/WorldImport1999.png](http://linloglayout.googlecode.com/svn/trunk/examples/WorldImport1999.png)

The screenshot shows a layout and a clustering of the world trade graph, where the nodes represent countries, and the edge weight of each node pair specifies the trade volume between the corresponding countries.  Both the layout (node positions) and the clustering (node colors) group the countries of the three major economic areas East Asia / Australia, America, and Europe.  The layout also reflects that countries like IRN and EGY are rather between the East Asian and the European group, and shows many smaller groups like CHN and HKG, AUS and NZL, and GBR and IRL.