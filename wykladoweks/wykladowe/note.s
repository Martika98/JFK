	.text
	.file	"note.ll"
	.globl	main                            # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
# %bb.0:
	movabsq	$4617765877924338074, %rax      # imm = 0x401599999999999A
	movq	%rax, -8(%rsp)
	movabsq	$4616302208045442662, %rax      # imm = 0x4010666666666666
	movq	%rax, -16(%rsp)
	movl	$17, -28(%rsp)
	movabsq	$-4614838538166547248, %rax     # imm = 0xBFF4CCCCCCCCCCD0
	movq	%rax, -24(%rsp)
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
