
package edu.umn.cs.melt.ableC.concretesyntax;

// top::UnaryExpr_c ::= 'sizeof' '(' ty::TypeName_c ')' 
public final class PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1 extends edu.umn.cs.melt.ableC.concretesyntax.NUnaryExpr_c {

	public static final int i__G_3 = 0;
	public static final int i__G_2 = 1;
	public static final int i_ty = 2;
	public static final int i__G_0 = 3;


	public static final Class<?> childTypes[] = {common.TerminalRecord.class,common.TerminalRecord.class,edu.umn.cs.melt.ableC.concretesyntax.NTypeName_c.class,common.TerminalRecord.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_concretesyntax_P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NUnaryExpr_c.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NUnaryExpr_c.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[4][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_ty] = new common.Lazy[edu.umn.cs.melt.ableC.concretesyntax.NTypeName_c.num_inh_attrs];

	}

	public PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1(final Object c__G_3, final Object c__G_2, final Object c_ty, final Object c__G_0, final Object a_core_location) {
		super(a_core_location);
		this.child__G_3 = c__G_3;
		this.child__G_2 = c__G_2;
		this.child_ty = c_ty;
		this.child__G_0 = c__G_0;

	}

	private Object child__G_3;
	public final common.TerminalRecord getChild__G_3() {
		return (common.TerminalRecord) (child__G_3 = common.Util.demand(child__G_3));
	}

	private Object child__G_2;
	public final common.TerminalRecord getChild__G_2() {
		return (common.TerminalRecord) (child__G_2 = common.Util.demand(child__G_2));
	}

	private Object child_ty;
	public final edu.umn.cs.melt.ableC.concretesyntax.NTypeName_c getChild_ty() {
		return (edu.umn.cs.melt.ableC.concretesyntax.NTypeName_c) (child_ty = common.Util.demand(child_ty));
	}

	private Object child__G_0;
	public final common.TerminalRecord getChild__G_0() {
		return (common.TerminalRecord) (child__G_0 = common.Util.demand(child__G_0));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i__G_3: return getChild__G_3();
			case i__G_2: return getChild__G_2();
			case i_ty: return getChild_ty();
			case i__G_0: return getChild__G_0();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i__G_3: return child__G_3;
			case i__G_2: return child__G_2;
			case i_ty: return child_ty;
			case i__G_0: return child__G_0;

			default: return null;
		}
	}

	@Override
	public final int getNumberOfChildren() {
		return 4;
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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1 erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:concretesyntax:P_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1";
	}

	static void initProductionAttributeDefinitions() {
		// top.ast = ast:unaryExprOrTypeTraitExpr(ast:sizeofOp(,location=$1.location), ast:typeNameExpr(ty.ast,),location=top.location)
		edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1.synthesizedAttributes[edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_UnaryExpr_c] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((edu.umn.cs.melt.ableC.abstractsyntax.NExpr)new edu.umn.cs.melt.ableC.abstractsyntax.PunaryExprOrTypeTraitExpr(new common.Thunk<Object>(context) { public final Object doEval() { return ((edu.umn.cs.melt.ableC.abstractsyntax.NUnaryTypeOp)new edu.umn.cs.melt.ableC.abstractsyntax.PsizeofOp(((core.NLocation)((common.TerminalRecord)context.childAsIs(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1.i__G_3)).location))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((edu.umn.cs.melt.ableC.abstractsyntax.NExprOrTypeName)new edu.umn.cs.melt.ableC.abstractsyntax.PtypeNameExpr(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.concretesyntax.PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1.i_ty, edu.umn.cs.melt.ableC.concretesyntax.Init.silver_langutil_ast__ON__edu_umn_cs_melt_ableC_concretesyntax_TypeName_c))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((core.NLocation)((edu.umn.cs.melt.ableC.concretesyntax.NUnaryExpr_c)context.undecorate()).getAnno_core_location()); } })); } };

	}

	public static final common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1> {

		@Override
		public PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1 invoke(final Object[] children, final Object[] annotations) {
			return new PP_edu_umn_cs_melt_ableC_concretesyntaxExpr_sv_270_1(children[0], children[1], children[2], children[3], annotations[0]);
		}
	};

}