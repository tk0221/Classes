
package edu.umn.cs.melt.ableC.abstractsyntax.gcc;

// top::Expr ::= ty::TypeName e::MemberDesignator 
public final class PoffsetofExpr extends edu.umn.cs.melt.ableC.abstractsyntax.NExpr {

	public static final int i_ty = 0;
	public static final int i_e = 1;


	public static final Class<?> childTypes[] = {edu.umn.cs.melt.ableC.abstractsyntax.NTypeName.class,edu.umn.cs.melt.ableC.abstractsyntax.gcc.NMemberDesignator.class};

	public static final int num_local_attrs = Init.count_local__ON__edu_umn_cs_melt_ableC_abstractsyntax_gcc_offsetofExpr;
	public static final String[] occurs_local = new String[num_local_attrs];

	public static final common.Lazy[] forwardInheritedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NExpr.num_inh_attrs];

	public static final common.Lazy[] synthesizedAttributes = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NExpr.num_syn_attrs];
	public static final common.Lazy[][] childInheritedAttributes = new common.Lazy[2][];

	public static final common.Lazy[] localAttributes = new common.Lazy[num_local_attrs];
	public static final common.Lazy[][] localInheritedAttributes = new common.Lazy[num_local_attrs][];

	static {
	childInheritedAttributes[i_ty] = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.NTypeName.num_inh_attrs];
	childInheritedAttributes[i_e] = new common.Lazy[edu.umn.cs.melt.ableC.abstractsyntax.gcc.NMemberDesignator.num_inh_attrs];

	}

	public PoffsetofExpr(final Object c_ty, final Object c_e, final Object a_core_location) {
		super(a_core_location);
		this.child_ty = c_ty;
		this.child_e = c_e;

	}

	private Object child_ty;
	public final edu.umn.cs.melt.ableC.abstractsyntax.NTypeName getChild_ty() {
		return (edu.umn.cs.melt.ableC.abstractsyntax.NTypeName) (child_ty = common.Util.demand(child_ty));
	}

	private Object child_e;
	public final edu.umn.cs.melt.ableC.abstractsyntax.gcc.NMemberDesignator getChild_e() {
		return (edu.umn.cs.melt.ableC.abstractsyntax.gcc.NMemberDesignator) (child_e = common.Util.demand(child_e));
	}



	@Override
	public Object getChild(final int index) {
		switch(index) {
			case i_ty: return getChild_ty();
			case i_e: return getChild_e();

			default: return null;
		}
	}

	@Override
	public Object getChildLazy(final int index) {
		switch(index) {
			case i_ty: return child_ty;
			case i_e: return child_e;

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
		throw new common.exceptions.SilverInternalError("Production edu:umn:cs:melt:ableC:abstractsyntax:gcc:offsetofExpr erroneously claimed to forward");
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
		return "edu:umn:cs:melt:ableC:abstractsyntax:gcc:offsetofExpr";
	}

	static void initProductionAttributeDefinitions() {
		// top.pp = concat([ text("__builtin_offsetof(",), ty.pp, text(", ",), e.pp, text(")",) ],)
		edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((silver.langutil.pp.NDocument)silver.langutil.pp.Pconcat.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Ptext((new common.StringCatter("__builtin_offsetof(")))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_TypeName), new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Ptext((new common.StringCatter(", ")))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_e, edu.umn.cs.melt.ableC.abstractsyntax.gcc.Init.silver_langutil_pp__ON__edu_umn_cs_melt_ableC_abstractsyntax_gcc_MemberDesignator), new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pcons.invoke(new common.Thunk<Object>(context) { public final Object doEval() { return ((silver.langutil.pp.NDocument)new silver.langutil.pp.Ptext((new common.StringCatter(")")))); } }, new common.Thunk<Object>(context) { public final Object doEval() { return ((common.ConsCell)core.Pnil.invoke()); } })); } })); } })); } })); } })); } })); } };
		// top.errors := ty.errors ++ e.errors
		if(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr] == null)
			edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr] = new silver.langutil.CAerrors(edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr);
		((common.CollectionAttribute)edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr]).setBase(new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pappend.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_TypeName), context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_e, edu.umn.cs.melt.ableC.abstractsyntax.gcc.Init.silver_langutil_errors__ON__edu_umn_cs_melt_ableC_abstractsyntax_gcc_MemberDesignator))); } });
		// top.defs = ty.defs ++ e.defs
		edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.synthesizedAttributes[edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_Expr] = new common.Lazy() { public final Object eval(final common.DecoratedNode context) { return ((common.ConsCell)core.Pappend.invoke(context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_ty, edu.umn.cs.melt.ableC.abstractsyntax.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_TypeName), context.childDecoratedSynthesizedLazy(edu.umn.cs.melt.ableC.abstractsyntax.gcc.PoffsetofExpr.i_e, edu.umn.cs.melt.ableC.abstractsyntax.gcc.Init.edu_umn_cs_melt_ableC_abstractsyntax_env_defs__ON__edu_umn_cs_melt_ableC_abstractsyntax_gcc_MemberDesignator))); } };

	}

	public static final common.NodeFactory<PoffsetofExpr> factory = new Factory();

	public static final class Factory extends common.NodeFactory<PoffsetofExpr> {

		@Override
		public PoffsetofExpr invoke(final Object[] children, final Object[] annotations) {
			return new PoffsetofExpr(children[0], children[1], annotations[0]);
		}
	};

}
