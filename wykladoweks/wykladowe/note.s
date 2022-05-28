	.text
	.file	"note.ll"
	.globl	main                            # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
# %bb.0:                                # %false2
	movl	$1, -4(%rsp)
	xorl	%eax, %eax
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
                                        # -- End function
	.type	strpi,@object                   # @strpi
	.section	.rodata,"a",@progbits
	.globl	strpi
strpi:
	.asciz	"%d\n"
	.size	strpi, 4

	.type	strpd,@object                   # @strpd
	.globl	strpd
strpd:
	.asciz	"%f\n"
	.size	strpd, 4

	.type	strs,@object                    # @strs
	.globl	strs
strs:
	.asciz	"%d"
	.size	strs, 3

	.section	".note.GNU-stack","",@progbits
