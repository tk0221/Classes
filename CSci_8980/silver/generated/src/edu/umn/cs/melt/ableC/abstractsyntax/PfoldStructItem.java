
package edu.umn.cs.melt.ableC.abstractsyntax;

public final class PfoldStructItem extends common.FunctionNode {

	public static final int i_l = 0;


	public static final Class<?> childTypes[] = { common.DecoratedNode.class };

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_abstractsyntax_foldStructItem;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[1][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static{

	}

	public PfoldStructItem(final Object c_l) {
		this.child_l = c_l;

	}

	private Object child_l;
	public final common.ConsCell getChild_l() {
		return (common.ConsCell) (child_l = common.Util.demand(child_l));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_l: return getChild_l();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_l: return child_l;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 1;
	}

	@Override
	public common.Lazy[] getLocalInheritedAttributes(final int key) {
		return localInheritedAttributes[key];
	}

	@Override
	public common.Lazy[] getChildInheritedAttributes(final int key) {
		return childInheritedAttributes[key];
	}

	@Override
	public common.Lazy getLocal(final int key) {
		return localAttributes[key];
	}

	@Override
	public final int getNumberOfLocalAttrs() {
		return num_local_attrs;
	}

	@Override
	public final String getNameOfLocalAttr(final int index) {
		return occurs_local[index];
	}

	@Override
	public String getName() {
		return "edu:umn:cs:melt:ableC:abstractsyntax:foldStructItem";
	}

	public static edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList invoke(final Object c_l) {
		try {
		final common.DecoratedNode context = new PfoldStructItem(c_l).decorate();
		//foldr(consStructItem, nilStructItem(,), l,)
		return (edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList)(((edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList)core.Pfoldr.invoke(edu.umn.cs.melt.ableC.abstractsyntax.PconsStructItem.factory, new common.Thunk<Object>(context) { public final Object doEval() { return ((edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList)new edu.umn.cs.melt.ableC.abstractsyntax.PnilStructItem()); } }, context.childAsIsLazy(edu.umn.cs.melt.ableC.abstractsyntax.PfoldStructItem.i_l))));

		} catch(Throwable t) {
			throw new common.exceptions.TraceException("Error while evaluating function edu:umn:cs:melt:ableC:abstractsyntax:foldStructItem", t);
		}
	}

	public static final common.NodeFactory<edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList> factory = new Factory();

	public static final class Factory extends common.NodeFactory<edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList> {
		@Override
		public edu.umn.cs.melt.ableC.abstractsyntax.NStructItemList invoke(final Object[] children, final Object[] namedNotApplicable) {
			return PfoldStructItem.invoke(children[0]);
		}
	};
}