
package edu.umn.cs.melt.ableC.abstractsyntax;

// top::MaybeExpr ::= 
public final class PnothingExpr extends edu.umn.cs.melt.ableC.abstractsyntax.NMaybeExpr {



	public static final Class<?> childTypes[] = {};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_abstractsyntax_nothingExpr;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NMaybeExpr.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NMaybeExpr.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[0][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {

	}

	public PnothingExpr() {
		super();

	}



	@Override
	public Object getChild(final int index) {
		switch(index) {

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 0;
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:abstractsyntax:nothingExpr erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:abstractsyntax:nothingExpr";
	}

	static void initProductionAttributeDefinitions() {
		// top.pp = notext(,)
		edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Pnotext()); } };
		// top.isJust = false
		edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.core_isJust__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return false; } };
		// top.errors := []
		if(edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr] == null)
			edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr] = new silver.langutil.CAerrors(edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr);
		((common.CollectionAttribute)edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr]).setBase(new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pnil.invoke()); } });
		// top.defs = []
		edu.umn.cs.melt.ableC.abstractsyntax.PnothingExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_MaybeExpr] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pnil.invoke()); } };

	}

	public static final common.NodeFactory<PnothingExpr> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PnothingExpr> {

		@Override
		public PnothingExpr invoke(final Object[] children, final Object[] annotations) {
			return new PnothingExpr();
		}
	};

}
