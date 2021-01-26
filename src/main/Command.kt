/**
 * @brief Command interface
 * All commands implementing this interface are deemed executable
 */
interface Command {
    /**
     * @brief execute a given command
     */
    fun execute(): Unit
}