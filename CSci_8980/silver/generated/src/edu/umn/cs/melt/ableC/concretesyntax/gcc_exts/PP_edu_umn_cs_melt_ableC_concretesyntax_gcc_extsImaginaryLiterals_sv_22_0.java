
package edu.umn.cs.melt.ableC.concretesyntax.gcc_exts;

// top::PrimaryExpr_c ::= l::ImaginaryFloatConstant_t 
public final class PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0 extends edu.umn.cs.melt.ableC.concretesyntax.NPrimaryExpr_c {

	public static final int i_l = 0;


	public static final Class<?> childTypes[] = {common.TerminalRecord.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_concretesyntax_gcc_exts_P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NPrimaryExpr_c.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NPrimaryExpr_c.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[1][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {

	}

	public PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0(final Object c_l, final Object a_core_location) {
		super(a_core_location);
		this.child_l = c_l;

	}

	private Object child_l;
	public final common.TerminalRecord getChild_l() {
		return (common.TerminalRecord) (child_l = common.Util.demand(child_l));
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:concretesyntax:gcc_exts:P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0 erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:concretesyntax:gcc_exts:P_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0";
	}

	static void initProductionAttributeDefinitions() {
		// top.ast = ast:imaginaryLiteral(l.lexeme,location=top.location)
		edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0.synthesizedAttributes[edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_PrimaryExpr_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NExpr)new edu.umn.cs.melt.ableC.abstractsyntax.gcc.PimaginaryLiteral(((common.StringCatter)((common.TerminalRecord)context.childAsIs(edu.umn.cs.melt.ableC.concretesyntax.gcc_exts.PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0.i_l)).lexeme), new common.Thunk<Object>(context) { public final Object doEval() { return ((core.NLocation)((edu.umn.cs.melt.ableC.concretesyntax.NPrimaryExpr_c)context.undecorate()).getAnno_core_location()); } })); } };

	}

	public static final common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0> {

		@Override
		public PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0 invoke(final Object[] children, final Object[] annotations) {
			return new PP_edu_umn_cs_melt_ableC_concretesyntax_gcc_extsImaginaryLiterals_sv_22_0(children[0], annotations[0]);
		}
	};

}