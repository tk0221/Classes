
package edu.umn.cs.melt.ableC.abstractsyntax;

// top::Decl ::= storage::[StorageClass] ty::BaseTypeExpr dcls::Declarators 
public final class PvariableDecls extends edu.umn.cs.melt.ableC.abstractsyntax.NDecl {

	public static final int i_storage = 0;
	public static final int i_ty = 1;
	public static final int i_dcls = 2;


	public static final Class<?> childTypes[] = {common.DecoratedNode.class,edu.umn.cs.melt.ableC.abstractsyntax.NBaseTypeExpr.class,edu.umn.cs.melt.ableC.abstractsyntax.NDeclarators.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_abstractsyntax_variableDecls;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NDecl.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NDecl.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[3][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_ty] = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NBaseTypeExpr.num_inh_attrs];
	childInheritedAttributes[i_dcls] = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NDeclarators.num_inh_attrs];

	}

	public PvariableDecls(final Object c_storage, final Object c_ty, final Object c_dcls) {
		super();
		this.child_storage = c_storage;
		this.child_ty = c_ty;
		this.child_dcls = c_dcls;

	}

	private Object child_storage;
	public final common.ConsCell getChild_storage() {
		return (common.ConsCell) (child_storage = common.Util.demand(child_storage));
	}

	private Object child_ty;
	public final edu.umn.cs.melt.ableC.abstractsyntax.NBaseTypeExpr getChild_ty() {
		return (edu.umn.cs.melt.ableC.abstractsyntax.NBaseTypeExpr) (child_ty = common.Util.demand(child_ty));
	}

	private Object child_dcls;
	public final edu.umn.cs.melt.ableC.abstractsyntax.NDeclarators getChild_dcls() {
		return (edu.umn.cs.melt.ableC.abstractsyntax.NDeclarators) (child_dcls = common.Util.demand(child_dcls));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_storage: return getChild_storage();
			case i_ty: return getChild_ty();
			case i_dcls: return getChild_dcls();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_storage: return child_storage;
			case i_ty: return child_ty;
			case i_dcls: return child_dcls;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 3;
	}

	@Override
	public common.Lazy getSynthesized(final int index) {
		return synthesizedAttributes[index];
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
	public boolean hasForward() {
		return false;
	}

	@Override
	public common.Node evalForward(final common.DecoratedNode context) {
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:abstractsyntax:variableDecls erroneously claimed to forward");
	}

	@Override
	public common.Lazy getForwardInheritedAttributes(final int index) {
		return forwardInheritedAttributes[index];
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
		return "edu:umn:cs:melt:ableC:abstractsyntax:variableDecls";
	}

	static void initProductionAttributeDefinitions() {
		// top.pp = concat((terminate(space(,), map((.pp), storage,),) :: [ ty.pp, space(,), ppImplode(text(", ",), dcls.pps,) ]),)
		edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pconcat.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pterminate.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pspace.invoke()); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pmap.invoke(new common.AttributeSection.Undecorated(edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_StorageClass), context.childAsIsLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_storage))); } })); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_BaseTypeExpr), new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pspace.invoke()); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pimplode.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Ptext((new common.StringCatter(", ")))); } }, context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_dcls, edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_pps__ON__edu_umn_cs_melt_ableC_abstractsyntax_Declarators))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pnil.invoke()); } })); } })); } })); } })); } })); } };
		// top.errors := ty.errors ++ dcls.errors
		if(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl] == null)
			edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl] = new silver.langutil.CAerrors(edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl);
		((common.CollectionAttribute)edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl]).setBase(new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pappend.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_BaseTypeExpr), context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_dcls, edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Declarators))); } });
		// top.defs = ty.defs ++ dcls.defs
		edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_Decl] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pappend.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_BaseTypeExpr), context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_dcls, edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_Declarators))); } };
		// dcls.baseType = ty.typerep
		edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.childInheritedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_dcls][edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_baseType__ON__edu_umn_cs_melt_ableC_abstractsyntax_Declarators] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NType)context.childDecorated(edu.umn.cs.melt.ableC.abstractsyntax.PvariableDecls.i_ty).synthesized(edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_typerep__ON__edu_umn_cs_melt_ableC_abstractsyntax_BaseTypeExpr)); } };

	}

	public static final common.NodeFactory<PvariableDecls> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PvariableDecls> {

		@Override
		public PvariableDecls invoke(final Object[] children, final Object[] annotations) {
			return new PvariableDecls(children[0], children[1], children[2]);
		}
	};

}
