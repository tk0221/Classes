
package edu.umn.cs.melt.ableC.concretesyntax;

// top::PostfixExpr_c ::= e::PostfixExpr_c '--' 
public final class PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0 extends edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c {

	public static final int i_e = 0;
	public static final int i__G_0 = 1;


	public static final Class<?> childTypes[] = {edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c.class,common.TerminalRecord.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_concretesyntax_P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[2][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_e] = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c.num_inh_attrs];

	}

	public PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0(final Object c_e, final Object c__G_0, final Object a_core_location) {
		super(a_core_location);
		this.child_e = c_e;
		this.child__G_0 = c__G_0;

	}

	private Object child_e;
	public final edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c getChild_e() {
		return (edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c) (child_e = common.Util.demand(child_e));
	}

	private Object child__G_0;
	public final common.TerminalRecord getChild__G_0() {
		return (common.TerminalRecord) (child__G_0 = common.Util.demand(child__G_0));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_e: return getChild_e();
			case i__G_0: return getChild__G_0();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_e: return child_e;
			case i__G_0: return child__G_0;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 2;
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0 erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0";
	}

	static void initProductionAttributeDefinitions() {
		// top.ast = ast:unaryOpExpr(ast:postDecOp(,location=$2.location), e.ast,location=top.location)
		edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0.synthesizedAttributes[edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_PostfixExpr_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NExpr)new edu.umn.cs.melt.ableC.abstractsyntax.PunaryOpExpr(new common.Thunk<Object>(context) { public final Object doEval() { return ((edu.umn.cs.melt.ableC.abstractsyntax.NUnaryOp)new edu.umn.cs.melt.ableC.abstractsyntax.PpostDecOp(((core.NLocation)((common.TerminalRecord)context.childAsIs(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0.i__G_0)).location))); } }, context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0.i_e, edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_PostfixExpr_c), new common.Thunk<Object>(context) { public final Object doEval() { return ((core.NLocation)((edu.umn.cs.melt.ableC.concretesyntax.NPostfixExpr_c)context.undecorate()).getAnno_core_location()); } })); } };

	}

	public static final common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0> {

		@Override
		public PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0 invoke(final Object[] children, final Object[] annotations) {
			return new PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_300_0(children[0], children[1], annotations[0]);
		}
	};

}
