A layout maps the nodes of a graph to positions in a plane (or a higher-dimensional space), while a clustering partions the set of nodes into disjoint subsets called clusters.
Layouts and clusterings can both naturally represent the density structure of graphs (community structure of networks), by placing densely connected nodes closely together or in the same cluster, and sparsely connected nodes further apart or in different clusters.

Layouts and clusterings complement each other. On the one hand, only clusterings can faithfully represent inherently high-dimensional structures. (Layouts with more than 2 or 3 dimensions can be easily computed, but are difficult to understand for human viewers.)
On the other hand, only layouts can show
  * the relationship between clusters, e.g., whether their separation is clear or fuzzy, and which nodes form their interface;
  * the internal structure of clusters, e.g., whether a dense cluster is composed of even denser subclusters; (layouts have no fixed resolution, and thus no "resolution limit", as observed for Modularity clusterings by Fortunato and Barthelemy, Proc. Natl. Acad. Sci. U.S.A. 104:36, 2007;)
  * the relationship between nodes and clusters, e.g., whether a node is central or peripheral to its cluster, or whether a node is closely related to several clusters.

For example, in the world trade graph shown below, both the layout (node positions) and the clustering (node colors) group the countries of the three major economic areas (East Asia / Australia, America, and Europe).  But only the layout reflects that countries like IRN and EGY are rather between the East Asian and the European group, and shows many smaller groups like CHN and HKG, AUS and NZL, and GBR and IRL.

![http://linloglayout.googlecode.com/svn/trunk/examples/WorldImport1999.png](http://linloglayout.googlecode.com/svn/trunk/examples/WorldImport1999.png)

In fact, the _k_ clusters of a clustering can be considered as positions in _(k-1)_-dimensional space, such that each pair of different clusters has the distance 1.  Then the Modularity measure for clusterings is a special case of energy models for layouts.  This explains why Modularity clusterings and LinLog energy layouts group the nodes similarly, as in the above screenshot.

More details about the relationship between (Modularity) clusterings and (LinLog) layouts can be found in the article [Modularity Clustering is Force-Directed Layout](http://arxiv.org/abs/0807.4052) (Preprint arXiv:0807.4052, 2008).