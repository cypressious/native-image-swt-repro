package info.rakhman.native_repro

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.*

private val display = Display()
private val shell = Shell(display)

private val menu = Menu(shell, SWT.POP_UP).apply {
    MenuItem(this, SWT.PUSH).apply {
        text = "Exit"
        addListener(SWT.Selection) {
            display.dispose()
        }
    }
}

private val trayItem = TrayItem(display.systemTray, SWT.NONE).apply {
    toolTipText = "My App"
    addListener(SWT.MenuDetect) { menu.isVisible = true }
}


fun pump() {
    while (!shell.isDisposed) {
        if (!display.readAndDispatch()) display.sleep()
    }
}

fun main(args: Array<String>) {
    pump()
}
