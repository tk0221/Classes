
package edu.umn.cs.melt.ableC.abstractsyntax;

// top::UnaryOp ::= 
public final class PpreIncOp extends edu.umn.cs.melt.ableC.abstractsyntax.NUnaryOp {



	public static final Class<?> childTypes[] = {};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_abstractsyntax_preIncOp;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NUnaryOp.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NUnaryOp.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[0][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {

	}

	public PpreIncOp(final Object a_core_location) {
		super(a_core_location);

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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:abstractsyntax:preIncOp erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:abstractsyntax:preIncOp";
	}

	static void initProductionAttributeDefinitions() {
		// top.pp = text("++",)
		edu.umn.cs.melt.ableC.abstractsyntax.PpreIncOp.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_UnaryOp] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Ptext((new common.StringCatter("++")))); } };
		// top.preExpr = true
		edu.umn.cs.melt.ableC.abstractsyntax.PpreIncOp.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_preExpr__ON__edu_umn_cs_melt_ableC_abstractsyntax_UnaryOp] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return true; } };

	}

	public static final common.NodeFactory<PpreIncOp> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PpreIncOp> {

		@Override
		public PpreIncOp invoke(final Object[] children, final Object[] annotations) {
			return new PpreIncOp(annotations[0]);
		}
	};

}
