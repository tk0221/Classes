
package edu.umn.cs.melt.ableC.concretesyntax.gcc_exts;

// top::Designation_c ::= d::ArrayDesignator_c 
public final class PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0 extends edu.umn.cs.melt.ableC.concretesyntax.NDesignation_c {

	public static final int i_d = 0;


	public static final Class<?> childTypes[] = {edu.umn.cs.melt.ableC.concretesyntax.NArrayDesignator_c.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_concretesyntax_gcc_exts_P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NDesignation_c.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NDesignation_c.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[1][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_d] = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NArrayDesignator_c.num_inh_attrs];

	}

	public PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0(final Object c_d, final Object a_core_location) {
		super(a_core_location);
		this.child_d = c_d;

	}

	private Object child_d;
	public final edu.umn.cs.melt.ableC.concretesyntax.NArrayDesignator_c getChild_d() {
		return (edu.umn.cs.melt.ableC.concretesyntax.NArrayDesignator_c) (child_d = common.Util.demand(child_d));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_d: return getChild_d();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_d: return child_d;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 1;
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:concretesyntax:gcc_exts:P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0 erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:concretesyntax:gcc_exts:P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0";
	}

	static void initProductionAttributeDefinitions() {
		// top.ast = d.ast
		edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0.synthesizedAttributes[edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_Designation_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NDesignator)context.childDecorated(edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0.i_d).synthesized(edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_ArrayDesignator_c)); } };
		// d.givenDesignator = ast:initialDesignator(,)
		edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0.childInheritedAttributes[edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0.i_d][edu.umn.cs.melt.ableC.concretesyntax.Init.edu_umn_cs_melt_ableC_concretesyntax_givenDesignator__ON__edu_umn_cs_melt_ableC_concretesyntax_ArrayDesignator_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NDesignator)new edu.umn.cs.melt.ableC.abstractsyntax.PinitialDesignator()); } };

	}

	public static final common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0> {

		@Override
		public PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0 invoke(final Object[] children, final Object[] annotations) {
			return new PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsExpr_sv_57_0(children[0], annotations[0]);
		}
	};

}
