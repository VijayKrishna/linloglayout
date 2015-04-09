**I don't see any node in the visualization window.**

Check the box "Show all names." Now node names should be visible; the nodes are right besides the names.  If the nodes are very small, then the distances between the nodes in the computed layout are very large, probably because the graph has (almost) unconnected components.  Increase the parameter `gravFactor` of the constructor `MinimizerBarnesHut` or `MinimizerClassic`, which is called in the `main` method of the class `LinLogLayout`, to 0.1 (or even higher, if necessary) to avoid that the unconnected components fly to far away.  See LayoutParameters for details.


**Some nodes are placed so closely together that I can hardly discern them.**

Decrease the parameter `repuExponent` and/or increase the parameter `attrExponent` of the constructor `MinimizerBarnesHut` or `MinimizerClassic`, which is called in the `main` method of the class `LinLogLayout`.  E.g., try the values -1.0 and 2.0 instead of the defaults 0.0 and 1.0.  See LayoutParameters for details.


**LinLogLayout prints "The node distances in the layout are extremely nonuniform."**

This means that the largest node distances in the layout are _much_ (by several orders of magnitude) larger than the smallest node distances, which makes it very difficult to find good energy minima.  Possible causes are unconnected components combined with an insufficient gravitation factor (see the first problem above), nodes of weight 0.0 (in the standard setting, these are nodes whose edges have all weight 0.0), or extremely nonuniform graph density combined with aggressive layout parameters (see the previous problem).  Especially for large graphs (> 1000 nodes), this message may appear a few times without indicating a serious problem.


**According to the tool output, the repulsion exponent changes during the energy minimization process.**

This is just an internal trick of the energy minimizer to produce better layouts, in particular to avoid bad local energy minima.  For some parameter values, energy is very difficult to minimize, and the minimizer is prone to get stuck in bad local minima.  In this case, the minimizer starts with "easier" parameter values that produce similar layouts, and then refines these layouts with the final (user-specified) parameter values.


**I want to modify the source code but don't understand the algorithms.**

Unfortunately, there is not detailed documentation of the algorithms.  `MinimizerBarnesHut` is based on a force calculation algorithm by Barnes and Hut, described in
  * J. Barnes and P. Hut. A hierarchical O(N logN) force-calculation algorithm. _Nature_, 324:446–449, 1986.
  * A. J. Quigley and P. Eades. FADE: Graph drawing, clustering, and visual abstraction. In J. Marks, editor, _Proceedings of the 8th International Symposium on Graph Drawing (GD 2000)_, LNCS 1984, pages 197–210, Berlin, 2001. Springer-Verlag.

Multi-level algorithms for Modularity clustering, of which `OptimizerModularity` is a simple example, are described in
  * A. Noack and R. Rotta. _[Multi-Level Algorithms for Modularity Clustering](http://arxiv.org/abs/0812.4073)_. Preprint arXiv:0812.4073, 2008.

**Further questions are welcome.**