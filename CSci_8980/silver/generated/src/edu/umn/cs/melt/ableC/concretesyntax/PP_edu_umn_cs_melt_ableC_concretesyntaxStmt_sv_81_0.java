
package edu.umn.cs.melt.ableC.concretesyntax;

// top::IterationStmt_c ::= 'while' '(' cond::Expr_c ')' body::Stmt_c 
public final class PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0 extends edu.umn.cs.melt.ableC.concretesyntax.NIterationStmt_c {

	public static final int i__G_4 = 0;
	public static final int i__G_3 = 1;
	public static final int i_cond = 2;
	public static final int i__G_1 = 3;
	public static final int i_body = 4;


	public static final Class<?> childTypes[] = {common.TerminalRecord.class,common.TerminalRecord.class,edu.umn.cs.melt.ableC.concretesyntax.NExpr_c.class,common.TerminalRecord.class,edu.umn.cs.melt.ableC.concretesyntax.NStmt_c.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_concretesyntax_P_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NIterationStmt_c.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NIterationStmt_c.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[5][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_cond] = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NExpr_c.num_inh_attrs];
	childInheritedAttributes[i_body] = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NStmt_c.num_inh_attrs];

	}

	public PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0(final Object c__G_4, final Object c__G_3, final Object c_cond, final Object c__G_1, final Object c_body, final Object a_core_location) {
		super(a_core_location);
		this.child__G_4 = c__G_4;
		this.child__G_3 = c__G_3;
		this.child_cond = c_cond;
		this.child__G_1 = c__G_1;
		this.child_body = c_body;

	}

	private Object child__G_4;
	public final common.TerminalRecord getChild__G_4() {
		return (common.TerminalRecord) (child__G_4 = common.Util.demand(child__G_4));
	}

	private Object child__G_3;
	public final common.TerminalRecord getChild__G_3() {
		return (common.TerminalRecord) (child__G_3 = common.Util.demand(child__G_3));
	}

	private Object child_cond;
	public final edu.umn.cs.melt.ableC.concretesyntax.NExpr_c getChild_cond() {
		return (edu.umn.cs.melt.ableC.concretesyntax.NExpr_c) (child_cond = common.Util.demand(child_cond));
	}

	private Object child__G_1;
	public final common.TerminalRecord getChild__G_1() {
		return (common.TerminalRecord) (child__G_1 = common.Util.demand(child__G_1));
	}

	private Object child_body;
	public final edu.umn.cs.melt.ableC.concretesyntax.NStmt_c getChild_body() {
		return (edu.umn.cs.melt.ableC.concretesyntax.NStmt_c) (child_body = common.Util.demand(child_body));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i__G_4: return getChild__G_4();
			case i__G_3: return getChild__G_3();
			case i_cond: return getChild_cond();
			case i__G_1: return getChild__G_1();
			case i_body: return getChild_body();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i__G_4: return child__G_4;
			case i__G_3: return child__G_3;
			case i_cond: return child_cond;
			case i__G_1: return child__G_1;
			case i_body: return child_body;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 5;
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0 erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0";
	}

	static void initProductionAttributeDefinitions() {
		// top.ast = ast:whileStmt(cond.ast, body.ast,)
		edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0.synthesizedAttributes[edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_IterationStmt_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NStmt)new edu.umn.cs.melt.ableC.abstractsyntax.PwhileStmt(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0.i_cond, edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_Expr_c), context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0.i_body, edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_Stmt_c))); } };

	}

	public static final common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0> {

		@Override
		public PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0 invoke(final Object[] children, final Object[] annotations) {
			return new PP_edu_umn_cs_melt_ableC_concretesyntaxStmt_sv_81_0(children[0], children[1], children[2], children[3], children[4], annotations[0]);
		}
	};

}
