
package core;

public final class Pfoldl1 extends common.FunctionNode {

	public static final int i_f = 0;
	public static final int i_l = 1;


	public static final Class<?> childTypes[] = { common.NodeFactory.class,common.DecoratedNode.class };

	public static final int num_local_attrs = Init.count_local__ON__core_foldl1;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[2][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static{

	}

	public Pfoldl1(final Object c_f, final Object c_l) {
		this.child_f = c_f;
		this.child_l = c_l;

	}

	private Object child_f;
	public final common.NodeFactory<Object> getChild_f() {
		return (common.NodeFactory<Object>) (child_f = common.Util.demand(child_f));
	}

	private Object child_l;
	public final common.ConsCell getChild_l() {
		return (common.ConsCell) (child_l = common.Util.demand(child_l));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_f: return getChild_f();
			case i_l: return getChild_l();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_f: return child_f;
			case i_l: return child_l;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 2;
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
		return "core:foldl1";
	}

	public static Object invoke(final Object c_f, final Object c_l) {
		try {
		final common.DecoratedNode context = new Pfoldl1(c_f, c_l).decorate();
		//if null(l,) then error("Applying foldl1 to empty list.",) else foldl(f, head(l,), tail(l,),)
		return (Object)((((Boolean)core.Pnull.invoke(context.childAsIsLazy(core.Pfoldl1.i_l))) ? ((Object)core.Perror.invoke((new common.StringCatter("Applying foldl1 to empty list.")))) : ((Object)core.Pfoldl.invoke(context.childAsIsLazy(core.Pfoldl1.i_f), new common.Thunk<Object>(context) { public final Object doEval() { return ((Object)core.Phead.invoke(context.childAsIsLazy(core.Pfoldl1.i_l))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Ptail.invoke(context.childAsIsLazy(core.Pfoldl1.i_l))); } }))));

		} catch(Throwable t) {
			throw new common.exceptions.TraceException("Error while evaluating function core:foldl1", t);
		}
	}

	public static final common.NodeFactory<Object> factory = new Factory();

	public static final class Factory extends common.NodeFactory<Object> {
		@Override
		public Object invoke(final Object[] children, final Object[] namedNotApplicable) {
			return Pfoldl1.invoke(children[0], children[1]);
		}
	};
}